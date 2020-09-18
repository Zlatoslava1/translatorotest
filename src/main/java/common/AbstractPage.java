package common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class AbstractPage {

    private WebDriver driver;

    protected AbstractPage(final WebDriver webDriver) {

        this.driver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    protected WebDriver getDriver() {
        return driver;
    }
}
