// Test of the function: Automatic language recognition for two languages
package webUiTests;

import common.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.GoogleTranslatePage;

import java.util.Arrays;

public class AutomaticLanguageRecognitionTest extends BaseTest {

    private final String baseUrl = "https://translate.google.com";
    private WebDriver driver = getDriver();

    //Check the interface language
    @Test
    public void languageInterfaceChecker() {
        driver.get(baseUrl);
        boolean isEnglish = false;
        String titleInEnglish = "Translate";
        GoogleTranslatePage googleTranslatePage = new GoogleTranslatePage(driver);
        isEnglish = googleTranslatePage.getTitle().getText().equals(titleInEnglish);
        Assert.assertTrue("Interface language is not English. Please change the settings.", isEnglish);
    }

    //The translator can recognize a language by one word
    @Test
    public void recognizePopularLanguageByOneWordTest() throws InterruptedException {
        driver.get(baseUrl);
        String expectedLanguage = "SPANISH - DETECTED";
        String enteredText = "siguientes";
        GoogleTranslatePage googleTranslatePage = new GoogleTranslatePage(driver);
        googleTranslatePage.getSourceField().sendKeys(enteredText);
        Thread.sleep(5000);
        Assert.assertEquals("The language was recognized incorrect.", expectedLanguage, googleTranslatePage.getAutoLanguageRecognitionField().getText());
    }

    //The translator can recognize a language by one word
    @Test
    public void recognizeRegularLanguageByOneWordTest() throws InterruptedException {
        driver.get(baseUrl);
        String expectedLanguage = "POLISH - DETECTED";
        String enteredText = "warzywa";
        GoogleTranslatePage googleTranslatePage = new GoogleTranslatePage(driver);
        googleTranslatePage.getSourceField().sendKeys(enteredText);
        Thread.sleep(5000);
        Assert.assertEquals("The language was recognized incorrect.", expectedLanguage, googleTranslatePage.getAutoLanguageRecognitionField().getText());
    }

    //The translator can recognize one language by one word if it exists in several languages
    @Test
    public void recognizeOneOfPopLanguagesByOneWordTest() throws InterruptedException {
        driver.get(baseUrl);
        String[] expectedLanguages = {"SPANISH - DETECTED", "ITALIAN - DETECTED"};
        String enteredText = "libro";
        boolean languageIsRecognized = false;
        GoogleTranslatePage googleTranslatePage = new GoogleTranslatePage(driver);
        googleTranslatePage.getSourceField().sendKeys(enteredText);
        Thread.sleep(5000);
        String recognisedLanguage = googleTranslatePage.getAutoLanguageRecognitionField().getText();
        for (String language : expectedLanguages) {
            if (language.equals(recognisedLanguage)) {
                languageIsRecognized = true;
                break;
            }
        }
        Assert.assertTrue("The language was recognized incorrect.\nExpected one of: " + Arrays.toString(expectedLanguages) +
                "\nActual: " + recognisedLanguage, languageIsRecognized);
    }

    //The translator can recognize the language by sentence
    @Test
    public void recognizePopLanguageByOneSentenceTest() throws InterruptedException {
        driver.get(baseUrl);
        String expectedLanguage = "SPANISH - DETECTED";
        String enteredText = "La compañía ha crecido rápidamente desde 160 empleados en noviembre de 2005 a 1100 en 201033\u200B34\u200B, 3800 empleados y contratistas en octubre de 201335";
        GoogleTranslatePage googleTranslatePage = new GoogleTranslatePage(driver);
        googleTranslatePage.getSourceField().sendKeys(enteredText);
        Thread.sleep(5000);
        Assert.assertEquals("The language was recognized incorrect.", expectedLanguage, googleTranslatePage.getAutoLanguageRecognitionField().getText());
    }

    //The translator can recognize the language by sentence
    @Test
    public void recognizeRegLanguageByOneSentenceTest() throws InterruptedException {
        driver.get(baseUrl);
        String expectedLanguage = "POLISH - DETECTED";
        String enteredText = "Jest to dwustopniowa rakieta nośna, przewidziana m.in. do wynoszenia na orbitę budowanych przez transportowych i załogowych statków kosmicznych";
        GoogleTranslatePage googleTranslatePage = new GoogleTranslatePage(driver);
        googleTranslatePage.getSourceField().sendKeys(enteredText);
        Thread.sleep(5000);
        Assert.assertEquals("The language was recognized incorrect.", expectedLanguage, googleTranslatePage.getAutoLanguageRecognitionField().getText());
    }

    //The translator can recognise a language if sentence contains two languages
    @Test
    public void recognizeMixLanguageTest() throws InterruptedException {
        driver.get(baseUrl);
        String[] expectedLanguages = {"POLISH - DETECTED", "ENGLISH - DETECTED"};
        String enteredText = "kosmicznych dragon";
        boolean languageIsRecognized = false;
        GoogleTranslatePage googleTranslatePage = new GoogleTranslatePage(driver);
        googleTranslatePage.getSourceField().sendKeys(enteredText);
        Thread.sleep(5000);
        String recognisedLanguage = googleTranslatePage.getAutoLanguageRecognitionField().getText();
        for (String language : expectedLanguages) {
            if (language.equals(recognisedLanguage)) {
                languageIsRecognized = true;
                break;
            }
        }
        Assert.assertTrue("The language was recognized incorrect.\nExpected one of: " + Arrays.toString(expectedLanguages) +
                "\nActual: " + recognisedLanguage, languageIsRecognized);
    }
}
