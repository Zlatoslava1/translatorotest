// Test of delete text option
package webUiTests;

import common.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.GoogleTranslatePage;

import java.util.List;
import java.util.stream.Collectors;

public class DeleteTextOptionTest extends BaseTest {

    private final String baseUrl = "https://translate.google.com";
    private final WebDriver driver = getDriver();

    // It is possible to delete text using the clean button
    @Test
    public void cleanButtonTest() throws InterruptedException {
        driver.get(baseUrl);
        String expectedResult="";
        String enteredText = "Fundusze uzyskane z poprzednich projektów Musk zainwestował w technikę kosmiczną. Zdecydował się na budowę rakiet, które znacząco zmniejszą koszty wynoszenia ładunków w przestrzeń kosmiczną. \nCel ma zostać osiągnięty przez";
        GoogleTranslatePage googleTranslatePage = new GoogleTranslatePage(driver);
        googleTranslatePage.getSourceField().sendKeys(enteredText);
        Thread.sleep(5000);
        googleTranslatePage.getCleanButton().click();
        Assert.assertEquals("Text was not deleted.", expectedResult, googleTranslatePage.getSourceField().getAttribute("value"));
    }

    // It is possible to delete text using backspace keyboard button
    @Test
    public void backspaceTest() throws InterruptedException {
        driver.get(baseUrl);
        String expectedResult="";
        String enteredText = "Cat";
        GoogleTranslatePage googleTranslatePage = new GoogleTranslatePage(driver);
        googleTranslatePage.getSourceField().sendKeys(enteredText);
        Thread.sleep(5000);
        googleTranslatePage.getSourceField().sendKeys(Keys.BACK_SPACE,Keys.BACK_SPACE,Keys.BACK_SPACE);
        Assert.assertEquals("Text was not deleted.", expectedResult, googleTranslatePage.getSourceField().getAttribute("value"));
    }

    //When source text is deleted translation is deleted as well
    @Test
    public void cleanTranslatedTextTest() throws InterruptedException {
        driver.get(baseUrl);
        String expectedResult="Translation";
        String enteredText = "Fundusze uzyskane z poprzednich projektów Musk zainwestował w technikę kosmiczną. Zdecydował się na budowę rakiet, które znacząco zmniejszą koszty wynoszenia ładunków w przestrzeń kosmiczną. \nCel ma zostać osiągnięty przez";
        GoogleTranslatePage googleTranslatePage = new GoogleTranslatePage(driver);
        googleTranslatePage.getSourceField().sendKeys(enteredText);
        Thread.sleep(5000);
        googleTranslatePage.getCleanButton().click();
        Thread.sleep(5000);
        Assert.assertEquals("Text was not deleted.", expectedResult, googleTranslatePage.getTranslationEmptyField().getText());
    }
}
