package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UserRegistrationPage extends PageBase {
    public UserRegistrationPage(WebDriver driver) {
        super(driver);
    }

    private final By genderRdoBtn = By.id("gender-male");
    private final By fnTxtBox = By.id("FirstName");
    private final By lnTxtBox = By.id("LastName");
    private final By emailTxtBox = By.id("Email");
    private final By passwordTxtBox = By.id("Password");
    private final By confirmPasswordTxtBox = By.id("ConfirmPassword");
    private final By registerBtn = By.id("register-button");
    private final By successMessage = By.cssSelector("div.result");
    private final By logoutLink = By.xpath("/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[2]/a");
    private final By myAccLink = By.linkText("My account");

    public void userRegistration(String firstName, String lastName, String email, String password) {
        clickButton(driver.findElement(genderRdoBtn));
        setTextElementText(driver.findElement(fnTxtBox), firstName);
        setTextElementText(driver.findElement(lnTxtBox), lastName);
        setTextElementText(driver.findElement(emailTxtBox), email);
        setTextElementText(driver.findElement(passwordTxtBox), password);
        setTextElementText(driver.findElement(confirmPasswordTxtBox), password);
        clickButton(driver.findElement(registerBtn));
    }

    public void userLogout() throws InterruptedException {
        Thread.sleep(200);
        clickButton(driver.findElement(logoutLink));
    }

    public void openMyAccountPage() {
        clickButton(driver.findElement(myAccLink));
    }

    public WebElement getSuccessMessage() {
        return driver.findElement(successMessage);
    }

    public WebElement getLogoutLink() {
        return driver.findElement(logoutLink);
    }

    public WebElement getMyAccLink() {
        return driver.findElement(myAccLink);
    }
}
