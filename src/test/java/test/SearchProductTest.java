package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProductDetailsPage;
import pages.SearchPage;

public class SearchProductTest extends TestBase{
    String productName = "Apple MacBook Pro 13-inch";
    SearchPage searchObj;
    ProductDetailsPage detailsObj;
    @Test
    public void userCanSearchForProducts(){
        searchObj = new SearchPage(driver);
        detailsObj = new ProductDetailsPage(driver);
        searchObj.productSearch(productName);
        searchObj.openProductDetailsPage();
        //Assert.assertTrue(detailsObj.productNameBreadCrumb.getText().equalsIgnoreCase(productName));
        Assert.assertEquals(detailsObj.getProductNameBreadCrumb().getText(),productName);
    }
}
