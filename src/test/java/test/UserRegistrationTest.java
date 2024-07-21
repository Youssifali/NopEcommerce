package test;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationTest extends TestBase
{
    HomePage homeObject ;
    UserRegistrationPage registerObject ;
    LoginPage loginObject ;

    @Test(priority=1,alwaysRun=true)
    public void UserCanRegisterSuccessfully()
    {
        homeObject = new HomePage(driver);
        homeObject.openRegistrationPage();
        registerObject = new UserRegistrationPage(driver);
        registerObject.userRegistration("youssif", "ali", "youssif3@gmail.com", "12345678");
        Assert.assertTrue(registerObject.getSuccessMessage().getText().contains("Your registration completed"));

    }

    @Test(priority = 2)
    public void RegisteredUserCanLogout() throws InterruptedException {
        registerObject.userLogout();
    }

    @Test(priority = 3)
    public void RegisteredUserCanLogin()
    {
        homeObject.openLoginPage();
        loginObject = new LoginPage(driver);
        loginObject.UserLogin("youssif2@gmail.com", "12345678");


    }
}
