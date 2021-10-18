package services;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.CatalogPage;

public class CatalogService {
    CatalogPage catalogPage = new CatalogPage();
    private final WebDriver driver;



    public CatalogService(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isCatalogPageShown(){
        return driver.findElement(catalogPage.getCatalogLabel()).isDisplayed();
    }

    public void openTvProductsListPage(){
        driver.findElement(catalogPage.getElectronicButton()).click();
        driver.findElement(catalogPage.getTvAndVideoButton()).click();
        driver.findElement(catalogPage.getTvButton()).click();
    }
}
