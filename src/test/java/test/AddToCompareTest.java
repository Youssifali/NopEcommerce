package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class AddToCompareTest extends TestBase{
    String firstProductName= "Apple MacBook Pro 13-inch";
    String secondProductName = "Asus N551JK-XO076H Laptop";
    ProductDetailsPage detailsPage;
    HomePage homeObj;
    CompareProductsPage compareObj;
    SearchPage searchObj;
    @Test(priority = 1)
    public void UserCanCompareProducts() throws InterruptedException {
        searchObj = new SearchPage(driver);
        detailsPage = new ProductDetailsPage(driver);
        compareObj = new CompareProductsPage(driver);

        searchObj.productSearchUsingAutoSuggest("mac");
        Assert.assertTrue(detailsPage.getProductNameBreadCrumb().getText().contains(firstProductName));
        detailsPage.addProductToComparePage();

        searchObj.productSearchUsingAutoSuggest("asus");
        Assert.assertTrue(detailsPage.getProductNameBreadCrumb().getText().contains(secondProductName));
        detailsPage.addProductToComparePage();
        compareObj.compareProducts();
        Thread.sleep(1000);
        Assert.assertTrue(compareObj.getFirstProductName().getText().equals("Asus N551JK-XO076H Laptop"));
        Assert.assertTrue(compareObj.getSecondProductName().getText().equals("Apple MacBook Pro 13-inch"));
        compareObj.compareProducts();
    }
        @Test(priority = 2)
        public void UserCanClearCompareList(){
        compareObj = new CompareProductsPage(driver);
        compareObj.clearCompareList();
        Assert.assertTrue(compareObj.getNoDataLbl().getText().contains("You have no items to compare."));
        }
}
