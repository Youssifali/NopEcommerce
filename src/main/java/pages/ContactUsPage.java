package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ContactUsPage extends PageBase {
    public ContactUsPage(WebDriver driver) {
        super(driver);
    }

    private final By nameTxt = By.id("FullName");
    private final By emailTxt = By.id("Email");
    private final By enquiryTxt = By.id("Enquiry");
    private final By submitBtn = By.name("send-email");
    public final By successMsg = By.xpath("//*[@id=\"main\"]/div/div/div/div[2]/div[2]");

    public void contactUs(String name, String email, String message) {
        setTextElementText(driver.findElement(nameTxt), name);
        setTextElementText(driver.findElement(emailTxt), email);
        setTextElementText(driver.findElement(enquiryTxt), message);
        clickButton(driver.findElement(submitBtn));
    }
    public WebElement getSuccessMsg(){
        return driver.findElement(successMsg);
    }
}
