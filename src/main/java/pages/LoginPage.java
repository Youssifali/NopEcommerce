package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends PageBase {
    private final WebDriver driver;
    private final By emailTxtBox = By.id("Email");
    private final By passwordTxtBox = By.id("Password");
    private final By loginBtn = By.cssSelector("#main > div > div > div > div.page-body > div.customer-blocks > div.returning-wrapper.fieldset > form > div.buttons > button");

    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void UserLogin(String email, String password) {
        driver.findElement(emailTxtBox).sendKeys(email);
        driver.findElement(passwordTxtBox).sendKeys(password);
        driver.findElement(loginBtn).click();
    }
}
