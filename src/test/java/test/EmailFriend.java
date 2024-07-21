package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class EmailFriend extends TestBase{
    HomePage homeObject ;
    UserRegistrationPage registerObject ;
    LoginPage loginObject ;
    String productName = "Apple MacBook Pro 13-inch";
    SearchPage searchObj;
    ProductDetailsPage detailsObj;
    EmailPage emailObj;
//1-User Registration
    @Test(priority=1,alwaysRun=true)
    public void UserCanRegisterSuccessfully()
    {
        homeObject = new HomePage(driver);
        homeObject.openRegistrationPage();
        registerObject = new UserRegistrationPage(driver);
        registerObject.userRegistration("youssif", "ali", "youssif333@gmail.com", "12345678");
        Assert.assertTrue(registerObject.getSuccessMessage().getText().contains("Your registration completed"));

    }
    //2-Search For Product
    @Test(priority = 2)
    public void UserCanSearchWithAutoSuggest(){
        searchObj=new SearchPage(driver);
        searchObj.productSearchUsingAutoSuggest("Mac");
        detailsObj = new ProductDetailsPage(driver);
        Assert.assertEquals(detailsObj.getProductNameBreadCrumb().getText(),productName);
    }
    //3-Email to Friend
@Test (priority = 3)
public void RegisteredUserCanSendProductToFriend(){
        detailsObj =new ProductDetailsPage(driver);
        detailsObj.openSendEmail();
        emailObj = new EmailPage(driver);
        emailObj.sendMailToFriend("test@test.com","test");
        Assert.assertTrue(emailObj.getMessageGetNotification().getText().contains("Your message has been sent."));

}
    //4-User Logout
    @Test(priority = 4)
    public void RegisteredUserCanLogout() throws InterruptedException {
        registerObject.userLogout();
    }
}
