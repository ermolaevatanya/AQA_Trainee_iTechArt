package framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import properties.ConfigProperties;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected WebDriver driver;

    @BeforeSuite
    public void initDriver() {
        System.setProperty("webdriver.chrome.driver", ConfigProperties.getProperty("chromedriver"));
        this.driver = new ChromeDriver();
        this.driver.manage().timeouts().implicitlyWait(Long.parseLong(ConfigProperties.getProperty("implicitlyWait")), TimeUnit.SECONDS);
    }

    @BeforeClass
    public void startDriver(){
        this.driver.get(ConfigProperties.getProperty("baseUrl"));
    }


    @AfterSuite
    public void closeDriver() {
        this.driver.quit();
    }
}
