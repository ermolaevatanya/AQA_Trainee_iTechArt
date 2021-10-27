package pages;

import org.openqa.selenium.By;

public class CatalogPage {
    private final By catalogLabel = By.className("catalog-navigation__title");
    private final By electronicButton = By.xpath("//li[@data-id='1']");
    private final String tvAndVideoButton = "//div[contains(text(),'%s')]";
    private final String tvButton = "//span[contains(text(),'%s')]";

    public By getCatalogLabel() {
        return catalogLabel;
    }

    public By getElectronicButton() {
        return electronicButton;
    }

    public String getTvAndVideoButton() {
        return tvAndVideoButton;
    }

    public String getTvButton() {
        return tvButton;
    }

}
