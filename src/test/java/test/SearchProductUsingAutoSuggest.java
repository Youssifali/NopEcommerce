package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProductDetailsPage;
import pages.SearchPage;

public class SearchProductUsingAutoSuggest extends TestBase{
    String productName = "Apple MacBook Pro 13-inch";
    SearchPage searchObj;
    ProductDetailsPage detailsObj;
    @Test
    public void UserCanSearchWithAutoSuggest(){
        searchObj=new SearchPage(driver);
        searchObj.productSearchUsingAutoSuggest("Mac");
        detailsObj = new ProductDetailsPage(driver);
        Assert.assertEquals(detailsObj.getProductNameBreadCrumb().getText(),productName);

    }
}
