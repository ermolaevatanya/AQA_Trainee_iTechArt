package services;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.HomePage;

public class HomeService {
    HomePage homePage = new HomePage();
    private final WebDriver driver;

    public HomeService(WebDriver driver) {
        this.driver = driver;
    }

    public void openCatalogPage(String navigationText){
        driver.findElement(By.xpath(String.format(homePage.getNavigationButton(), navigationText))).click();
    }
}
