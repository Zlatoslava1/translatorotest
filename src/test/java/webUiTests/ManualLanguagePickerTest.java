// Test of the function: Manual language picker
package webUiTests;

import common.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import pages.GoogleTranslatePage;

public class ManualLanguagePickerTest extends BaseTest {

    private final String baseUrl = "https://translate.google.com";
    private final WebDriver driver = getDriver();

    //****Language "translate from" tests:
    
    // It is possible to open the drop-down menu with languages. The attribute of language list should change in this case
    @Test
    public void openDropDownLanguageListLeftMenuTest() throws InterruptedException {
        driver.get(baseUrl);
        String expectedIsDisplayedAttribute = "";
        GoogleTranslatePage googleTranslatePage = new GoogleTranslatePage(driver);
        googleTranslatePage.getDropdowmLanguageLeftList().click();
        Thread.sleep(3000);
        Assert.assertEquals("The attribute \"display\" for open drop-down list should be empty " //div[@class= "outer-wrap"]/ div[@class="language-list"]
                , expectedIsDisplayedAttribute, googleTranslatePage.getAttributeValue("//div[@class=\"language_list_languages language_list_sl_list tw-ll-top\"]/..", "style"));
    }

    // It is possible to close the drop-down menu with languages. The attribute of language list should change in this case
    @Test
    public void closeDropDownLanguageListLeftMenuTest() throws InterruptedException {
        driver.get(baseUrl);
        String expectedIsDisplayedAttribute = "display: none;";
        GoogleTranslatePage googleTranslatePage = new GoogleTranslatePage(driver);
        googleTranslatePage.getDropdowmLanguageLeftList().click();
        Thread.sleep(3000);
        googleTranslatePage.getDropdowmLanguageLeftList().click();
        Thread.sleep(3000);
        Assert.assertEquals("The attribute \"display\" for open drop-down list should be empty ",
                expectedIsDisplayedAttribute, googleTranslatePage.getAttributeValue("//div[@class=\"language_list_languages language_list_sl_list tw-ll-top\"]/..", "style"));
    }

    //It is possible to choose the language from the drop-down menu and the language will have "aria-pressed" attribute true
    @Test
    public void chooseFromDropDownLanguageListLeftMenuTest() throws InterruptedException {
        driver.get(baseUrl);
        String expectedAttributeValue = "true";
        GoogleTranslatePage googleTranslatePage = new GoogleTranslatePage(driver);
        googleTranslatePage.findElementByXpathAndCLick("//div [contains(text(),\"Got it\")]");
        googleTranslatePage.getDropdowmLanguageLeftList().click();
        Thread.sleep(3000);
        Actions act = new Actions(driver);
        act.moveToElement(driver.findElement(By.xpath("//div [@class=\"language-list-unfiltered-langs-sl_list\"]/div/div/div [contains (text(),\"Spanish\")]"))).click().perform();
        Thread.sleep(3000);
        Assert.assertEquals(expectedAttributeValue, googleTranslatePage.findElementByXpath("//div[@class=\"sl-sugg\"]/div/div[@value=\"es\"]").getAttribute("aria-pressed"));
    }

    //Not selected language will not have "aria-pressed" attribute true
    @Test
    public void chooseFromDropDownLanguageListNegativeLeftMenuTest() throws InterruptedException {
        driver.get(baseUrl);
        String expectedAttributeValue = "false";
        GoogleTranslatePage googleTranslatePage = new GoogleTranslatePage(driver);
        googleTranslatePage.findElementByXpathAndCLick("//div [contains(text(),\"Got it\")]");
        googleTranslatePage.getDropdowmLanguageLeftList().click();
        Thread.sleep(3000);
        Actions act = new Actions(driver);
        act.moveToElement(driver.findElement(By.xpath("//div [@class=\"language-list-unfiltered-langs-sl_list\"]/div/div/div [contains (text(),\"Spanish\")]"))).click().perform();
        Thread.sleep(3000);
        Assert.assertEquals(expectedAttributeValue, googleTranslatePage.findElementByXpath("//div[@class=\"sl-sugg\"]/div/div[@value=\"en\"]").getAttribute("aria-pressed"));
    }

    //It is possible to select the language form the language bar. The selected language has "aria-pressed" attribute true
    @Test
    public void languageSelectedAttributeLeftMenuTest() throws InterruptedException {
        driver.get(baseUrl);
        String expectedAttributeValueAfter = "true";
        GoogleTranslatePage googleTranslatePage = new GoogleTranslatePage(driver);
        Thread.sleep(3000);
        googleTranslatePage.findElementByXpathAndCLick("//div[@class=\"sl-sugg\"]/div[@class=\"sl-sugg-button-container\"]/div[contains(@value,\"en\")]");
        Thread.sleep(3000);
        Assert.assertEquals(expectedAttributeValueAfter, googleTranslatePage.findElementByXpath
                ("//div[@class=\"sl-sugg\"]/div/div[@value=\"en\"]").getAttribute(("aria-pressed")));
    }

    // It is possible to find the language using the search bar
    @Test
    public void searchLanguageLeftMenuTest() throws InterruptedException {
        driver.get(baseUrl);
        String wordForSearch = "Poli";
        GoogleTranslatePage googleTranslatePage = new GoogleTranslatePage(driver);
        googleTranslatePage.findElementByXpathAndCLick("//div [contains(text(),\"Got it\")]");
        googleTranslatePage.getDropdowmLanguageLeftList().click();
        Thread.sleep(3000);
        googleTranslatePage.getSearchLanguagesLeftField().sendKeys(wordForSearch);
        Thread.sleep(3000);
        Assert.assertEquals(wordForSearch, googleTranslatePage.findElementByXpath
                ("//div[@class=\"language_list_languages language_list_sl_list tw-ll-top\"]/div/div [@class=\"language_list_item language_list_item_language_name\"]/div/b").getText());
    }

    // It is possible to select the language using the search bar
    @Test
    public void searchAndSelectLanguageLeftMenuTest() throws InterruptedException {
        driver.get(baseUrl);
        String wordForSearch = "Poli";
        String expectedAttributeValue = "true";
        GoogleTranslatePage googleTranslatePage = new GoogleTranslatePage(driver);
        googleTranslatePage.findElementByXpathAndCLick("//div [contains(text(),\"Got it\")]");
        googleTranslatePage.getDropdowmLanguageLeftList().click();
        Thread.sleep(3000);
        googleTranslatePage.getSearchLanguagesLeftField().sendKeys(wordForSearch);
        Thread.sleep(3000);
        googleTranslatePage.findElementByXpath("//div [@class=\"language_list_item language_list_item_language_name\"]/div/b").click();
        Thread.sleep(3000);
        Assert.assertEquals(expectedAttributeValue, googleTranslatePage.findElementByXpath("//div[@class=\"sl-sugg\"]/div/div[@value=\"pl\"]").getAttribute("aria-pressed"));
    }
    
    //The same tests for right menu
    //****Language "translate to" tests:

    // It is possible to open the drop-down menu with languages. The attribute of language list should change in this case
    @Test
    public void openDropDownLanguageListRightMenuTest() throws InterruptedException {
        driver.get(baseUrl);
        String expectedIsDisplayedAttribute = "";
        GoogleTranslatePage googleTranslatePage = new GoogleTranslatePage(driver);
        googleTranslatePage.getDropdowmLanguageRightList().click();
        Thread.sleep(3000);
        Assert.assertEquals("The attribute \"display\" for open drop-down list should be empty"
                , expectedIsDisplayedAttribute, googleTranslatePage.getAttributeValue("//div[@class=\"language_list_languages language_list_tl_list tw-ll-top\"]/..","style"));
    }

    // It is possible to close the drop-down menu with languages. The attribute of language list should change in this case
    @Test
    public void closeDropDownLanguageListRightMenuTest() throws InterruptedException {
        driver.get(baseUrl);
        String expectedIsDisplayedAttribute = "display: none;";
        GoogleTranslatePage googleTranslatePage = new GoogleTranslatePage(driver);
        googleTranslatePage.getDropdowmLanguageRightList().click();
        Thread.sleep(3000);
        googleTranslatePage.getDropdowmLanguageRightList().click();
        Thread.sleep(3000);
        Assert.assertEquals("The attribute \"display\" for open drop-down list should be empty ",
                expectedIsDisplayedAttribute, googleTranslatePage.getAttributeValue("//div[@class=\"language_list_languages language_list_tl_list tw-ll-top\"]/..", "style"));
    }

    //It is possible to choose the language from the drop-down menu and the language will have "aria-pressed" attribute true
    @Test
    public void chooseFromDropDownLanguageListRightMenuTest() throws InterruptedException {
        driver.get(baseUrl);
        String expectedAttributeValue = "true";
        GoogleTranslatePage googleTranslatePage = new GoogleTranslatePage(driver);
        googleTranslatePage.findElementByXpathAndCLick("//div [contains(text(),\"Got it\")]");
        googleTranslatePage.getDropdowmLanguageRightList().click();
        Thread.sleep(3000);
        Actions act = new Actions(driver);
        act.moveToElement(driver.findElement(By.xpath("//div[@class=\"language_list_languages language_list_tl_list tw-ll-top\"]//div [contains (text(),\"Spanish\")]"))).click().perform();
        Thread.sleep(3000);
        Assert.assertEquals(expectedAttributeValue, googleTranslatePage.findElementByXpath("//div[@class=\"tl-sugg\"]/div/div[@value=\"es\"]").getAttribute("aria-pressed"));
    }

    //Not selected language will not have "aria-pressed" attribute true
    @Test
    public void chooseFromDropDownLanguageListNegativeRightMenuTest() throws InterruptedException {
        driver.get(baseUrl);
        String expectedAttributeValue = "false";
        GoogleTranslatePage googleTranslatePage = new GoogleTranslatePage(driver);
        googleTranslatePage.findElementByXpathAndCLick("//div [contains(text(),\"Got it\")]");
        googleTranslatePage.getDropdowmLanguageRightList().click();
        Thread.sleep(3000);
        Actions act = new Actions(driver);
        act.moveToElement(driver.findElement(By.xpath("//div[@class=\"language_list_languages language_list_tl_list tw-ll-top\"]//div [contains (text(),\"Spanish\")]"))).click().perform();
        Thread.sleep(3000);
        Assert.assertEquals(expectedAttributeValue, googleTranslatePage.findElementByXpath("//div[@class=\"tl-sugg\"]/div/div[@value=\"en\"]").getAttribute("aria-pressed"));
    }

    //It is possible to select the language form the language bar. The selected language has "aria-pressed" attribute true
    @Test
    public void languageSelectedAttributeRightMenuTest() throws InterruptedException {
        driver.get(baseUrl);
        String expectedAttributeValueAfter = "true";
        GoogleTranslatePage googleTranslatePage = new GoogleTranslatePage(driver);
        Thread.sleep(3000);
        googleTranslatePage.findElementByXpathAndCLick("//div[@class=\"tl-sugg\"]/div[@class=\"sl-sugg-button-container\"]/div[contains(@value,\"en\")]");
        Thread.sleep(3000);
        Assert.assertEquals(expectedAttributeValueAfter, googleTranslatePage.findElementByXpath
                ("//div[@class=\"tl-sugg\"]/div/div[@value=\"en\"]").getAttribute(("aria-pressed")));
    }

    // It is possible to find the language using the search bar
    @Test
    public void searchLanguageRightMenuTest() throws InterruptedException {
        driver.get(baseUrl);
        String wordForSearch = "Poli";
        GoogleTranslatePage googleTranslatePage = new GoogleTranslatePage(driver);
        googleTranslatePage.findElementByXpathAndCLick("//div [contains(text(),\"Got it\")]");
        googleTranslatePage.getDropdowmLanguageRightList().click();
        Thread.sleep(3000);
        googleTranslatePage.getSearchLanguagesRightField().sendKeys(wordForSearch);
        Thread.sleep(3000);
        Assert.assertEquals(wordForSearch, googleTranslatePage.findElementByXpath
                ("//div[@class=\"language_list_languages language_list_tl_list tw-ll-top\"]/div/div [@class=\"language_list_item language_list_item_language_name\"]/div/b").getText());
    }

    // It is possible to select the language using the search bar
    @Test
    public void searchAndSelectLanguageRightMenuTest() throws InterruptedException {
        driver.get(baseUrl);
        String wordForSearch = "Poli";
        String expectedAttributeValue = "true";
        GoogleTranslatePage googleTranslatePage = new GoogleTranslatePage(driver);
        googleTranslatePage.findElementByXpathAndCLick("//div [contains(text(),\"Got it\")]");
        googleTranslatePage.getDropdowmLanguageRightList().click();
        Thread.sleep(3000);
        googleTranslatePage.getSearchLanguagesRightField().sendKeys(wordForSearch);
        Thread.sleep(3000);
        googleTranslatePage.findElementByXpath
                ("//div[@class=\"language_list_languages language_list_tl_list tw-ll-top\"]/div/div [@class=\"language_list_item language_list_item_language_name\"]/div").click();
        Thread.sleep(3000);
        Assert.assertEquals(expectedAttributeValue, googleTranslatePage.findElementByXpath("//div[@class=\"tl-sugg\"]/div/div[@value=\"pl\"]").getAttribute("aria-pressed"));
    }
    
    
}

