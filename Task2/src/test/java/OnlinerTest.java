import framework.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import services.CatalogService;
import services.HomeService;
import services.TvProductsListService;

public class OnlinerTest extends BaseTest {
    private HomeService homeService;
    private CatalogService catalogService;
    private TvProductsListService tvProductsListService;

    @BeforeClass
    public void setupPages() {
        homeService = new HomeService(driver);
        catalogService = new CatalogService(driver);
        tvProductsListService = new TvProductsListService(driver);
    }

    @Parameters({"brandText", "screenResolutionText", "maxPrice", "diagonalFrom", "diagonalTo", "screen"})
    @Test
    public void testOnliner(String brandText, String screenResolutionText, String maxPrice, String diagonalFrom, String diagonalTo, String screen) {
        SoftAssert softAssert = new SoftAssert();
        homeService.openCatalogPage("Каталог");
        softAssert.assertTrue(catalogService.isCatalogPageShown());

        catalogService.openTvProductsListPage("Телевидение", "Телевизоры");
        softAssert.assertTrue(tvProductsListService.isTvProductsListPageShown());

        tvProductsListService.filterTvProductsList(brandText, screenResolutionText, maxPrice, diagonalFrom, diagonalTo);
        softAssert.assertTrue(tvProductsListService.isScreenFiltersCorrect(screen));
        softAssert.assertTrue(tvProductsListService.isBrandFilterCorrect(brandText));
        softAssert.assertTrue(tvProductsListService.isPriceCorrect(maxPrice));
        softAssert.assertAll();
    }

}
