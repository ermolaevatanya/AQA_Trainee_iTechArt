package pages;

import org.openqa.selenium.By;

public class CatalogPage {
    private final By catalogLabel = By.className("catalog-navigation__title");
    private final By electronicButton = By.xpath("//li[@data-id='1']");
    private final By tvAndVideoButton = By.xpath("//div[contains(text(),'Телевидение')]");
    private final By tvButton = By.xpath("//span[contains(text(),'Телевизоры')]");

    public By getCatalogLabel() {
        return catalogLabel;
    }

    public By getElectronicButton() {
        return electronicButton;
    }

    public By getTvAndVideoButton() {
        return tvAndVideoButton;
    }

    public By getTvButton() {
        return tvButton;
    }
}

