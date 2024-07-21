package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyAccountPage extends PageBase {
    private final WebDriver driver;
    private final By changePasswordLink = By.linkText("Change password");
    private final By oldPasswordTxt = By.id("OldPassword");
    private final By newPasswordTxt = By.id("NewPassword");
    private final By confirmPasswordTxt = By.id("ConfirmNewPassword");
    private final By changePasswordBtn = By.xpath("//*[@id='main']/div/div[2]/div/div[2]/form/div[2]/button");
    private final By result = By.xpath("//*[@id='bar-notification']/div/p");
    private final By closeBtn = By.xpath("//*[@id='bar-notification']/div/span");

    public MyAccountPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void openChangePasswordPage() {
        driver.findElement(changePasswordLink).click();
    }

    public void changePassword(String oldPassword, String newPassword) {
        driver.findElement(oldPasswordTxt).sendKeys(oldPassword);
        driver.findElement(newPasswordTxt).sendKeys(newPassword);
        driver.findElement(confirmPasswordTxt).sendKeys(newPassword);
        driver.findElement(changePasswordBtn).click();
    }

    public void getCloseNotification() {
         driver.findElement(closeBtn).click();
    }
    public WebElement getResult(){
        return driver.findElement(result);
    }
}
