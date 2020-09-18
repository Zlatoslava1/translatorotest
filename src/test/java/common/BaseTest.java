package common;

import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    private WebDriver driver;

    protected BaseTest() {
        initDriver();
    }

    protected WebDriver getDriver() {
        return driver;
    }

    @After
    public void tearDown() {
        driver.close();
        driver.quit();
    }

    private void initDriver() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

}
