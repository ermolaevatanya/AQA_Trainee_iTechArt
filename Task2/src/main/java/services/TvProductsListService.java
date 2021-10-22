package services;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.TvProductsListPage;

import java.util.List;
import java.util.Random;


public class TvProductsListService {
    TvProductsListPage tvProductsListPage = new TvProductsListPage();
    private WebDriver driver;


    public TvProductsListService(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isTvProductsListPageShown() {
        WebDriverWait wait = new WebDriverWait(driver, 200);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("schema-products")));
        return driver.findElement(tvProductsListPage.getTvLabel()).isDisplayed();
    }

    public void brandFilter(String brandText){
        WebElement brandElement = driver.findElement(By.xpath(String.format(tvProductsListPage.getBrandCheckbox(), brandText)));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", brandElement);
        WebDriverWait wait = new WebDriverWait(driver, 200);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='schema-product__title']")));
    }
    public void priceFilter(String maxPrice){
        driver.findElement(tvProductsListPage.getMaxPriceInput()).sendKeys(maxPrice);
        WebDriverWait wait = new WebDriverWait(driver, 200);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='schema-product__title']")));
    }

    public void screenFilter(String screenResolutionText){
        WebElement screenResolutionElement = driver.findElement(By.xpath(String.format(tvProductsListPage.getScreenResolutionCheckbox(), screenResolutionText)));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", screenResolutionElement);
        WebDriverWait wait = new WebDriverWait(driver, 200);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='schema-product__title']")));
    }
    public void diagonalFilter(String diagonalFrom, String diagonalTo){
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", driver.findElement(tvProductsListPage.getDiagonalFromSelector()));
        driver.findElement(tvProductsListPage.getDiagonalFromSelector()).sendKeys(diagonalFrom);
        WebDriverWait wait = new WebDriverWait(driver, 200);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='schema-product__title']")));

        executor.executeScript("arguments[0].click();", driver.findElement(tvProductsListPage.getDiagonalToSelector()));
        driver.findElement(tvProductsListPage.getDiagonalToSelector()).sendKeys(diagonalTo);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='schema-product__title']")));
    }


    public void filterTvProductsList(String brandText, String screenResolutionText, String maxPrice, String diagonalFrom, String diagonalTo) {
        WebDriverWait wait = new WebDriverWait(driver, 200);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("schema-products")));
        brandFilter(brandText);
        priceFilter(maxPrice);
        screenFilter(screenResolutionText);
        diagonalFilter(diagonalFrom, diagonalTo);
    }

    public boolean isScreenFiltersCorrect(String screen){
        List<WebElement> tvList = driver.findElements(By.className("schema-product"));
        Random random = new Random();
        int randomValue = random.nextInt(tvList.size());
        final String screenFilter = "//span[contains(text(), '%s')]";
        return tvList.get(randomValue).findElement(By.xpath(String.format(screenFilter, screen))).isDisplayed();
    }

    public boolean isBrandFilterCorrect(String brandText){
        List<WebElement> tvList = driver.findElements(By.className("schema-product"));
        Random random = new Random();
        int randomValue = random.nextInt(tvList.size());
        final String brandFilter = "//div[@class='schema-product__title']/descendant::a/span[contains(text(), '%s')]";
        return tvList.get(randomValue).findElement(By.xpath(String.format(brandFilter, brandText))).isDisplayed();
    }

    public boolean isPriceCorrect(String maxPrice){
        List<WebElement> tvList = driver.findElements(By.className("schema-product"));
        Random random = new Random();
        int randomValue = random.nextInt(tvList.size());

        String price = tvList.get(randomValue).findElement(By.xpath("//div[@class='schema-product__price']/descendant::a/span")).getText();
        String numbersOfPrice = price.replaceAll("[^0-9]+[^,]]", "").substring(0, 3);
        int tvPrice = Integer.parseInt(numbersOfPrice);
        return  tvPrice < Integer.parseInt(maxPrice);
        }
}
