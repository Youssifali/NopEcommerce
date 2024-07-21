package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AddToCartPage;
import pages.ProductDetailsPage;
import pages.SearchPage;

public class AddToCartTest extends TestBase{
    String productName = "Apple MacBook Pro 13-inch";
    SearchPage searchObj;
    ProductDetailsPage detailsObj;
    AddToCartPage cartPage;
    @Test(priority = 1)
    public void userCanSearchForProducts(){
        searchObj = new SearchPage(driver);
        detailsObj = new ProductDetailsPage(driver);
        searchObj.productSearch(productName);
        searchObj.openProductDetailsPage();
        //Assert.assertTrue(detailsObj.productNameBreadCrumb.getText().equalsIgnoreCase(productName));
        Assert.assertEquals(detailsObj.getProductNameBreadCrumb().getText(),productName);
    }
    @Test(priority = 2)
    public void userCanAddProductToShoppingCart()  {
        detailsObj = new ProductDetailsPage(driver);
        detailsObj.addProductToCart();

    }

    @Test(dependsOnMethods ="userCanAddProductToShoppingCart" )
    public void USerCanUpdateQuantity() throws InterruptedException {
        cartPage = new AddToCartPage(driver);
        cartPage.updateQuantity("3");
        System.out.println(cartPage.getTotalLbl() .getText());
        Thread.sleep(2000);
        Assert.assertTrue(cartPage.getTotalLbl().getText().contains("$5,400.00"));

    }
    @Test(priority = 3)
    public void UserCanRemoveProductFromShoppingCart() {
        cartPage = new AddToCartPage(driver);
        cartPage.removeProductFromCart();
    }
}
