package pages;

public class HomePage {
    private final String navigationButton = "//a[contains(text(),'%s')]";

    public String getNavigationButton() {
        return navigationButton;
    }

}
