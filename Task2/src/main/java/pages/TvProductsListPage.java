package pages;

import org.openqa.selenium.By;

public class TvProductsListPage {
    private final By tvLabel = By.id("schema-products");
    private final By samsungCheckbox = By.xpath("//span[contains(text(),'Samsung')]");
    private final By maxPriceInput = By.xpath("//input[@placeholder='до']");
    private final By screenResolutionCheckbox = By.xpath("//span[contains(text(),'1920')]");
    private final By diagonalFromSelector = By.xpath("//select[@class = 'schema-filter-control__item']");
    private final By diagonalToSelector = By.xpath("//div[@class = 'schema-filter-control schema-filter-control_select']/following-sibling::div/select");

    public By getTvLabel() {
        return tvLabel;
    }

    public By getSamsungCheckbox() {
        return samsungCheckbox;
    }

    public By getMaxPriceInput() {
        return maxPriceInput;
    }

    public By getScreenResolutionCheckbox() {
        return screenResolutionCheckbox;
    }

    public By getDiagonalFromSelector() {
        return diagonalFromSelector;
    }

    public By getDiagonalToSelector() {
        return diagonalToSelector;
    }
}
