package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ContactUsPage;
import pages.HomePage;

public class ContactUsTest extends TestBase{
    HomePage home;
    ContactUsPage contactPage;
    String email = "test@test.com";
    String name = "youssif";
    String enquiry = "test";
    @Test
    public void UserCanContactUs(){
        home = new HomePage(driver);
        home.openContactUsPage();
        contactPage = new ContactUsPage(driver);
        contactPage.contactUs(name,email,enquiry);
        Assert.assertTrue(contactPage.getSuccessMsg().getText().contains("Your enquiry has been successfully sent to the store owner."));

    }
}
