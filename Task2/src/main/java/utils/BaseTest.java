package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected static final String BASE_URL = "https://onliner.by";

    protected WebDriver driver;

    @BeforeSuite
    public void initDriver() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/driver/chromedriver");
        this.driver = new ChromeDriver();
        this.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @BeforeMethod
    public void startDriver() {
        this.driver.get(BASE_URL);
    }

    @AfterSuite
    public void closeDriver() {
        this.driver.quit();
    }
}
