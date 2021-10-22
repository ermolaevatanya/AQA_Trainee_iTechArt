package pages;

import org.openqa.selenium.By;

public class TvProductsListPage {
    private final By tvLabel = By.id("schema-products");
    private final String brandCheckbox = "//span[contains(text(),'%s')]";
    private final By maxPriceInput = By.xpath("//input[@placeholder='до']");
    private final String screenResolutionCheckbox = "//span[contains(text(),'%s')]";
    private final By diagonalFromSelector = By.xpath("//select[@class = 'schema-filter-control__item']");
    private final By diagonalToSelector = By.xpath("//div[@class = 'schema-filter-control schema-filter-control_select']/following-sibling::div/select");

    public By getTvLabel() {
        return tvLabel;
    }

    public String getBrandCheckbox() {
        return brandCheckbox;
    }

    public By getMaxPriceInput() {
        return maxPriceInput;
    }

    public String getScreenResolutionCheckbox() {
        return screenResolutionCheckbox;
    }

    public By getDiagonalFromSelector() {
        return diagonalFromSelector;
    }

    public By getDiagonalToSelector() {
        return diagonalToSelector;
    }
}
