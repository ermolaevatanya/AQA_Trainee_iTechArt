package pages;

import org.openqa.selenium.By;

public class HomePage {

    private final String navigationButton = "//a[contains(text(),'%s')]";

    public String getNavigationButton() {
        return navigationButton;
    }
}
