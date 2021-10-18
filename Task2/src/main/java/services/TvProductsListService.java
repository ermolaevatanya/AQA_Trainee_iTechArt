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


    public void filterTvProductsList(String maxPrice, String diagonalFrom, String diagonalTo) {
        WebDriverWait wait = new WebDriverWait(driver, 200);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("schema-products")));

        WebElement element = driver.findElement(tvProductsListPage.getSamsungCheckbox());

        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='schema-product__title']")));

        driver.findElement(tvProductsListPage.getMaxPriceInput()).sendKeys(maxPrice);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='schema-product__title']")));

        executor.executeScript("arguments[0].click();", driver.findElement(tvProductsListPage.getScreenResolutionCheckbox()));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='schema-product__title']")));

        executor.executeScript("arguments[0].click();", driver.findElement(tvProductsListPage.getDiagonalFromSelector()));
        driver.findElement(tvProductsListPage.getDiagonalFromSelector()).sendKeys(diagonalFrom);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='schema-product__title']")));

        executor.executeScript("arguments[0].click();", driver.findElement(tvProductsListPage.getDiagonalToSelector()));
        driver.findElement(tvProductsListPage.getDiagonalToSelector()).sendKeys(diagonalTo);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='schema-product__title']")));

    }

    public boolean isScreenFiltersCorrect(){
        List<WebElement> tvList = driver.findElements(By.className("schema-product"));
        Random random = new Random();
        int randomValue = random.nextInt(tvList.size());
        return tvList.get(randomValue).findElement(By.xpath("//span[contains(text(), '43\" 1920x1080')]")).isDisplayed();
    }

    public boolean isBrandFilterCorrect(){
        List<WebElement> tvList = driver.findElements(By.className("schema-product"));
        Random random = new Random();
        int randomValue = random.nextInt(tvList.size());
        return tvList.get(randomValue).findElement(By.xpath("//span[contains(text(), 'Телевизор Samsung')]")).isDisplayed();
    }

    public boolean isPriceCorrect(){
        List<WebElement> tvList = driver.findElements(By.className("schema-product"));
        Random random = new Random();
        int randomValue = random.nextInt(tvList.size());
        String price = tvList.get(randomValue).findElement(By.className("schema-product__price")).findElement(By.tagName("span")).getText();
        String numbersOfPrice = price.replaceAll("[^0-9]+[^,]]", "").substring(0, 3);
        int tvPrice = Integer.parseInt(numbersOfPrice);
            return  tvPrice < 1000;
        }
}
