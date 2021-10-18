package pages;

import org.openqa.selenium.By;

public class HomePage {

    private final By catalogButton = By.xpath("//a[contains(text(),'Каталог')]");

    public By getCatalogButton() {
        return catalogButton;
    }
}
