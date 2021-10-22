import utils.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import services.CatalogService;
import services.HomeService;
import services.TvProductsListService;

import static org.testng.Assert.assertTrue;

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

    @Parameters("navigationText")
    @Test
    public void testCatalogPageOpened(String navigationText) {
        homeService.openCatalogPage(navigationText);
        assertTrue(catalogService.isCatalogPageShown());
    }

    @Parameters({"navigationText", "tvAndVideoText", "tvText"})
    @Test
    public void testTvProductsListPageOpened(String navigationText, String tvAndVideoText, String tvText) {
        homeService.openCatalogPage(navigationText);
        catalogService.openTvProductsListPage(tvAndVideoText, tvText);
        assertTrue(tvProductsListService.isTvProductsListPageShown());
    }

    @Parameters({"navigationText", "tvAndVideoText", "tvText", "brandText", "screenResolutionText", "maxPrice", "diagonalFrom", "diagonalTo", "screen"})
    @Test
    public void testFilterTvProductsListPage(String navigationText, String tvAndVideoText, String tvText,
                                             String brandText, String screenResolutionText, String maxPrice,
                                             String diagonalFrom, String diagonalTo, String screen) {
        homeService.openCatalogPage(navigationText);
        catalogService.openTvProductsListPage(tvAndVideoText, tvText);
        tvProductsListService.filterTvProductsList(brandText, screenResolutionText, maxPrice, diagonalFrom, diagonalTo);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(tvProductsListService.isScreenFiltersCorrect(screen));
        softAssert.assertTrue(tvProductsListService.isBrandFilterCorrect(brandText));
        softAssert.assertTrue(tvProductsListService.isPriceCorrect(maxPrice));
    }
}

