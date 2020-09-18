package pages;

import common.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class GoogleTranslatePage extends AbstractPage {

    public GoogleTranslatePage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = "//textarea [@id=\"source\"]")
    private WebElement sourceField;

    @FindBy(xpath = "//span[@class=\"tlid-translation translation\"]/span")
    private WebElement translationNonEmptyField;

    @FindBy(xpath = "//div[@class=\"tlid-results-container results-container empty\"]")
    private WebElement translationEmptyField;

    @FindBy(xpath = "//div [@class=\"goog-inline-block jfk-button jfk-button-standard jfk-button-collapse-right jfk-button-checked\"]")
    private WebElement autoLanguageRecognitionField;

    @FindBy(xpath = "//div[@class=\"gb_Td gb_1c gb_2c\"]//div[@class=\"gb_sc\"]/div/a/span[@class=\"gb_ge gb_0c\"]")
    private WebElement title;

    @FindBy(xpath = "//div [@class=\"sl-more tlid-open-source-language-list\"]")
    private WebElement dropdowmLanguageLeftList;

    @FindBy(xpath = "//div[@class=\"tl-more tlid-open-target-language-list\"]")
    private WebElement dropdowmLanguageRightList;

    @FindBy(xpath = "//input [@id=\"sl_list-search-box\"]")
    private WebElement searchLanguagesLeftField;

    @FindBy(xpath = "//input [@id=\"tl_list-search-box\"]")
    private WebElement searchLanguagesRightField;

    @FindBy(xpath = "//div[@aria-label=\"Swap languages (Ctrl+Shift+S)\"]")
    private WebElement swapLanguagesButton;

    @FindBy(xpath = "//div[@class=\"clear-wrap\"]/div[@aria-label=\"Clear text\"]")
    private WebElement cleanButton;

    public WebElement getSwapLanguagesButton() {
        return swapLanguagesButton;
    }

    public WebElement getCleanButton() {
        return cleanButton;
    }

    public WebElement getSearchLanguagesLeftField() {
        return searchLanguagesLeftField;
    }

    public WebElement getTranslationNonEmptyField() {
        return translationNonEmptyField;
    }

    public WebElement getTranslationEmptyField() {
        return translationEmptyField;
    }

    public WebElement getSearchLanguagesRightField() {
        return searchLanguagesRightField;
    }

    public void findElementByXpathAndCLick(String xpath) {
        getDriver().findElement(By.xpath(xpath)).click();
    }

    public WebElement findElementByXpath(String xpath) {
        return getDriver().findElement(By.xpath(xpath));
    }

    public String getAttributeValue(String xpath, String attribute) {
        return getDriver().findElement(By.xpath(xpath)).getAttribute(attribute);
    }

    public WebElement getDropdowmLanguageLeftList() {
        return dropdowmLanguageLeftList;
    }

    public WebElement getDropdowmLanguageRightList() {
        return dropdowmLanguageRightList;
    }

    public WebElement getSourceField() {
        return sourceField;
    }

    public WebElement getTitle() {
        return title;
    }

    public WebElement getAutoLanguageRecognitionField() {
        return autoLanguageRecognitionField;
    }
}
