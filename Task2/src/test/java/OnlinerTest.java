import browser.Browser;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import services.CatalogService;
import services.HomeService;
import services.TvProductsListService;

import static org.testng.Assert.assertTrue;

public class OnlinerTest extends Browser {
    private HomeService homeService;
    private CatalogService catalogService;
    private TvProductsListService tvProductsListService;

    @BeforeClass
    public void setupPages(){
        homeService = new HomeService(driver);
        catalogService = new CatalogService(driver);
        tvProductsListService = new TvProductsListService(driver);
    }

    @Test
    public void testCatalogPageOpened() {
        homeService.openCatalogPage();
        assertTrue(catalogService.isCatalogPageShown());
    }

    @Test
    public void testTvProductsListPageOpened() {
        homeService.openCatalogPage();
        catalogService.openTvProductsListPage();
        assertTrue(tvProductsListService.isTvProductsListPageShown());
    }

    @Parameters({"maxPrice", "diagonalFrom", "diagonalTo"})
    @Test
    public void testFilterTvProductsListPage(String maxPrice, String diagonalFrom, String diagonalTo){
        homeService.openCatalogPage();
        catalogService.openTvProductsListPage();
        tvProductsListService.filterTvProductsList(maxPrice, diagonalFrom, diagonalTo);
        assertTrue(tvProductsListService.isScreenFiltersCorrect());
        assertTrue(tvProductsListService.isBrandFilterCorrect());
        assertTrue(tvProductsListService.isPriceCorrect());
    }
}
