package pages;

import org.openqa.selenium.By;

public class TvProductsListPage {
    private final By tvLabel = By.id("schema-products");
    private final String brandCheckbox = "//span[contains(text(),'%s')]";
    private final By maxPriceInput = By.xpath("//input[@placeholder='до']");
    private final String screenResolutionCheckbox = "//span[contains(text(),'%s')]";
    private final By diagonalFromSelector = By.xpath("//select[@class = 'schema-filter-control__item']");
    private final By diagonalToSelector = By.xpath("//div[@class = 'schema-filter-control schema-filter-control_select']/following-sibling::div/select");
    private final By productTitleLabel = By.xpath("//div[@class='schema-product__title']");
    private final By tvListLabel = By.className("schema-product");
    private final String screenFilter = "//span[contains(text(), '%s')]";
    private final String brandFilter = "//div[@class='schema-product__title']/descendant::a/span[contains(text(), '%s')]";
    private final String priceFilter = "//div[@class='schema-product__price']/descendant::a/span";

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

    public By getProductTitleLabel() {
        return productTitleLabel;
    }

    public By getTvListLabel() {
        return tvListLabel;
    }

    public String getScreenFilter() {
        return screenFilter;
    }

    public String getBrandFilter() {
        return brandFilter;
    }

    public String getPriceFilter() {
        return priceFilter;
    }
}
