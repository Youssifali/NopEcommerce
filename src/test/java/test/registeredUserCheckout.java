package test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.*;

public class registeredUserCheckout extends TestBase {
    HomePage homeObject  ;

    UserRegistrationPage registerObject ;
    String productName = "Apple MacBook Pro 13-inch";
    SearchPage searchObj;
    ProductDetailsPage detailsObj ;
    CheckoutPage checkoutObj;
    AddToCartPage cartPage;
    OrderDetailsPage orderDetailsObj;
    @BeforeClass
    public void setUp() {
        homeObject = new HomePage(driver);
        registerObject = new UserRegistrationPage(driver);
        searchObj = new SearchPage(driver);
        detailsObj = new ProductDetailsPage(driver);
        checkoutObj = new CheckoutPage(driver);
        cartPage = new AddToCartPage(driver);
        orderDetailsObj = new OrderDetailsPage(driver);
    }

    @Test(priority = 1, alwaysRun = true)
    public void UserCanRegisterSuccessfully() {
        homeObject.openRegistrationPage();
        registerObject.userRegistration("youssif", "ali", "youssif903@gmail.com", "12345678");
        Assert.assertTrue(registerObject.getSuccessMessage().getText().contains("Your registration completed"));

    }

    @Test(priority = 2)
    public void UserCanSearchWithAutoSuggest() {
        searchObj.productSearchUsingAutoSuggest("Mac");
        Assert.assertEquals(detailsObj.getProductNameBreadCrumb().getText(), productName);

    }

    @Test(priority = 3)
    public void userCanAddProductToShoppingCart() throws InterruptedException {
        detailsObj.addProductToCart();
        Thread.sleep(2000);

        Assert.assertTrue(cartPage.getTotalLbl().getText().contains("$3,600.00"));
    }
    @Test(priority = 4)

    public void UserCanCheckoutProduct()  {
        cartPage.openCheckoutPage();
        checkoutObj.registeredUserCheckoutProduct("Egypt", "test", "123", "0123456789", "cairo");
        checkoutObj.confirmOrder();
        checkoutObj.viewOrderDetails();
        Assert.assertTrue(driver.getCurrentUrl().contains("orderdetails"));
        orderDetailsObj.DownloadPDF();
        orderDetailsObj.printOrderDetails();
    }

    @Test(priority = 5)

    public void RegisteredUserCanLogout() throws InterruptedException {
        registerObject.userLogout();
    }
}