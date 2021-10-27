package services;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.CatalogPage;

public class CatalogService {
    CatalogPage catalogPage = new CatalogPage();
    private final WebDriver driver;

    public CatalogService(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isCatalogPageShown() {
        return driver.findElement(catalogPage.getCatalogLabel()).isDisplayed();
    }

    public void openTvProductsListPage(String tvAndVideoText, String tvText) {
        driver.findElement(catalogPage.getElectronicButton()).click();
        driver.findElement(By.xpath(String.format(catalogPage.getTvAndVideoButton(), tvAndVideoText))).click();
        driver.findElement(By.xpath(String.format(catalogPage.getTvButton(), tvText))).click();
    }
}
