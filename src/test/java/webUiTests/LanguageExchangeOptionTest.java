// Test of the Language exchange option
package webUiTests;

import common.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.GoogleTranslatePage;

public class LanguageExchangeOptionTest extends BaseTest {

    private final String baseUrl = "https://translate.google.com";
    private final WebDriver driver = getDriver();

    //    It is possible to exchange languages
    @Test
    public void exchangeLanguagesTest() throws InterruptedException {
        driver.get(baseUrl);
        GoogleTranslatePage googleTranslatePage = new GoogleTranslatePage(driver);
        String languageLeftSearch = "Spanish";
        String languageRightSearch = "English";
        String expectedLeftLanguageCode = "en";
        String expectedRightLanguageCode = "es";
        googleTranslatePage.findElementByXpathAndCLick("//div [contains(text(),\"Got it\")]");
        googleTranslatePage.getDropdowmLanguageLeftList().click();
        Thread.sleep(3000);
        googleTranslatePage.getSearchLanguagesLeftField().sendKeys(languageLeftSearch);
        Thread.sleep(3000);
        googleTranslatePage.findElementByXpath("//div [@class=\"language_list_item language_list_item_language_name\"]/div/b").click();
        Thread.sleep(3000);
        googleTranslatePage.getDropdowmLanguageRightList().click();
        Thread.sleep(3000);
        googleTranslatePage.getSearchLanguagesRightField().sendKeys(languageRightSearch);
        Thread.sleep(3000);
        googleTranslatePage.findElementByXpath
                ("//div[@class=\"language_list_languages language_list_tl_list tw-ll-top\"]/div/div [@class=\"language_list_item language_list_item_language_name\"]/div").click();
        Thread.sleep(3000);
        googleTranslatePage.getSwapLanguagesButton().click();
        Thread.sleep(3000);
        String leftLanguage = googleTranslatePage.findElementByXpath("//div[@class=\"sl-sugg\"]//div[@aria-pressed=\"true\"]").getAttribute("value");
        String rightLanguage = googleTranslatePage.findElementByXpath("//div[@class=\"tl-sugg\"]//div[@aria-pressed=\"true\"]").getAttribute("value");
        ;
        Assert.assertEquals("Left language is incorrect.",leftLanguage, expectedLeftLanguageCode);
        Assert.assertEquals("Right language is incorrect.", rightLanguage, expectedRightLanguageCode);
    }

    //When languages are exchanging translated text are exchanging as well
    @Test
    public void exchangeTextWithLanguagesTest() throws InterruptedException {
        driver.get(baseUrl);
        GoogleTranslatePage googleTranslatePage = new GoogleTranslatePage(driver);
        String languageLeftSearch = "Spanish";
        String languageRightSearch = "English";
        String wordForTranslation = "dos";
        googleTranslatePage.findElementByXpathAndCLick("//div [contains(text(),\"Got it\")]");
        googleTranslatePage.getDropdowmLanguageLeftList().click();
        Thread.sleep(3000);
        googleTranslatePage.getSearchLanguagesLeftField().sendKeys(languageLeftSearch);
        Thread.sleep(3000);
        googleTranslatePage.findElementByXpath("//div [@class=\"language_list_item language_list_item_language_name\"]/div/b").click();
        Thread.sleep(3000);
        googleTranslatePage.getDropdowmLanguageRightList().click();
        Thread.sleep(3000);
        googleTranslatePage.getSearchLanguagesRightField().sendKeys(languageRightSearch);
        Thread.sleep(3000);
        googleTranslatePage.findElementByXpath
                ("//div[@class=\"language_list_languages language_list_tl_list tw-ll-top\"]/div/div [@class=\"language_list_item language_list_item_language_name\"]/div").click();
        Thread.sleep(3000);
        googleTranslatePage.getSourceField().sendKeys(wordForTranslation);
        String originalTranslate = googleTranslatePage.getTranslationNonEmptyField().getText();
        Thread.sleep(3000);
        googleTranslatePage.getSwapLanguagesButton().click();
        Thread.sleep(3000);
        Assert.assertEquals("Right translation is incorrect.",wordForTranslation, googleTranslatePage.getTranslationNonEmptyField().getText() );
        Assert.assertEquals("Left translation is incorrect.", originalTranslate, googleTranslatePage.getSourceField().getAttribute("value"));
    }

}
