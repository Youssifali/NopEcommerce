package test;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.UserRegistrationPage;


public class MyAccountTest extends TestBase {
    HomePage homeObject ;
    UserRegistrationPage registerObject ;
    MyAccountPage myAccObj;
    LoginPage loginObject;
    String oldPassword = "123456";
    String newPassword = "1234567";
    String firstName ="youssif";
    String lastName = "Ali";
    String email = "youssifali15555255@gmail.com";
    @Test(priority=1,alwaysRun=true)
    public void UserCanRegisterSuccessfully()
    {
        homeObject = new HomePage(driver);
        homeObject.openRegistrationPage();
        registerObject = new UserRegistrationPage(driver);
        registerObject.userRegistration(firstName, lastName, email, oldPassword);
        Assert.assertTrue(registerObject.getSuccessMessage().getText().contains("Your registration completed"));
}
    @Test(priority=2)
    public void RegisteredUserCanLogout() throws InterruptedException {
        registerObject.userLogout();
    }
    @Test(priority=3)
    public void RegisteredUserCanLogin()
    {
        homeObject.openLoginPage();
        loginObject = new LoginPage(driver);
        loginObject.UserLogin(email, oldPassword);
        Assert.assertTrue(registerObject.getLogoutLink().getText().contains("Log out"));

    }
@Test(priority =4)
    public void registeredUserCanChangePassword(){
        myAccObj = new MyAccountPage(driver);
        registerObject.openMyAccountPage();
        myAccObj.openChangePasswordPage();
        myAccObj.changePassword(oldPassword,newPassword);
    Assert.assertTrue(myAccObj.getResult().getText().contains("Password was changed" ));


}
    @Test(dependsOnMethods = "registeredUserCanChangePassword")
    public void UserLogout() throws InterruptedException {
        myAccObj.getCloseNotification();        
        registerObject.userLogout();

    }



}
