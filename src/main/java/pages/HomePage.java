package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends PageBase {

    public HomePage(WebDriver driver) {
        super(driver);
        js = (JavascriptExecutor) driver;
        actions = new Actions(driver);
    }

    private final By registerLink = By.linkText("Register");
    private final By loginLink = By.linkText("Log in");
    private final By contactUsLink = By.xpath("/html/body/div[6]/div[4]/div[1]/div[1]/ul/li[6]/a");
    private final By currencyDropDownList = By.id("customerCurrency");
    private final By computerMenu = By.xpath("/html/body/div[6]/div[2]/ul[1]/li[1]/a");
    private final By noteBook = By.xpath("/html/body/div[6]/div[2]/ul[1]/li[1]/ul/li[2]/a");

    public void openRegistrationPage() {
        clickButton(driver.findElement(registerLink));
    }

    public void openLoginPage() {
        clickButton(driver.findElement(loginLink));
    }

    public void openContactUsPage() {
        scrollToBottom();
        clickButton(driver.findElement(contactUsLink));
    }

    public void changeCurrency() {
        select = new Select(driver.findElement(currencyDropDownList));
        select.selectByVisibleText("Euro");

    }

    public void selectNotebooksMenu() {
        WebElement computerMenuElement = driver.findElement(computerMenu);
        WebElement notebookElement = driver.findElement(noteBook);
        actions.moveToElement(computerMenuElement)
                .moveToElement(notebookElement)
                .click()
                .build()
                .perform();
    }
}
