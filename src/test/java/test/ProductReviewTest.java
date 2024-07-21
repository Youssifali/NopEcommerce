package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class ProductReviewTest extends TestBase{
//1-User Registration
HomePage homeObject ;
    UserRegistrationPage registerObject ;
    String productName = "Apple MacBook Pro 13-inch";
    SearchPage searchObj;
    ProductDetailsPage detailsObj;
    ProductReviewPage productReviewObj;
    //1-User Registration
    @Test(priority=1,alwaysRun=true)
    public void UserCanRegisterSuccessfully()
    {
        homeObject = new HomePage(driver);
        homeObject.openRegistrationPage();
        registerObject = new UserRegistrationPage(driver);
        registerObject.userRegistration("youssif", "ali", "youssif6@gmail.com", "12345678");
        Assert.assertTrue(registerObject.getSuccessMessage().getText().contains("Your registration completed"));

    }
    //2-Search for product
    @Test(priority = 2)
    public void UserCanSearchWithAutoSuggest(){
        searchObj=new SearchPage(driver);
        searchObj.productSearchUsingAutoSuggest("Mac");
        detailsObj = new ProductDetailsPage(driver);
        Assert.assertEquals(detailsObj.getProductNameBreadCrumb().getText(),productName);
    }
    //3-Add Review
    @Test(priority = 3)
    public void RegisteredUserCanReviewProduct(){
        detailsObj.openAddReviewPage();
        productReviewObj = new ProductReviewPage(driver);
        productReviewObj.addProductReview("New Review","the product is awesome");
        Assert.assertTrue(productReviewObj.getReviewNotification().getText().contains("Product review is successfully added."));

    }

    @Test(priority = 4)
    public void RegisteredUserCanLogout() throws InterruptedException {
        productReviewObj.closeNotification();
        registerObject.userLogout();
    }
}
