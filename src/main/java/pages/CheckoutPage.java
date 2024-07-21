package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutPage extends PageBase {
    private final By fName = By.id("BillingNewAddress_FirstName");
    private final By lName = By.id("BillingNewAddress_LastName");
    private final By email = By.id("BillingNewAddress_Email");
    private final By countryList = By.id("BillingNewAddress_CountryId");
    private final By cityTxt = By.id("BillingNewAddress_City");
    private final By addressTxt = By.id("BillingNewAddress_Address1");
    private final By zipPostalCodeTxt = By.id("BillingNewAddress_ZipPostalCode");
    private final By phoneNumber = By.id("BillingNewAddress_PhoneNumber");
    private final By continueBtn = By.xpath("//*[@id=\"billing-buttons-container\"]/button[2]");
    private final By shippingMethodRdo = By.id("shippingoption_1");
    private final By continueShippingBtn = By.xpath("//*[@id=\"shipping-method-buttons-container\"]/button");
    private final By continuePaymentMethodBtn = By.xpath("//*[@id=\"payment-method-buttons-container\"]/button");
    private final By continueInfo = By.xpath("//*[@id=\"payment-info-buttons-container\"]/button");
    private  final By productName = By.xpath("//*[@id=\"shopping-cart-form\"]/div[1]/table/tbody/tr/td[3]/a");
    private final By confirmBtn = By.xpath("//*[@id=\"confirm-order-buttons-container\"]/button");
    private final By thankYouLbl = By.xpath("//*[@id=\"main\"]/div/div/div/div[1]/h1");
    private final By successMsg = By.xpath("//*[@id=\"main\"]/div/div/div/div[2]/div/div[1]");
    private final By orderDetailsLink = By.xpath("//*[@id=\"main\"]/div/div/div/div[2]/div/div[2]/div[2]/a");

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public void registeredUserCheckoutProduct(String countryName, String address, String postalCode, String phone, String city) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        WebElement countryElement = wait.until(ExpectedConditions.visibilityOfElementLocated(countryList));
        Select select = new Select(countryElement);
        select.selectByVisibleText(countryName);

        setTextElementText(driver.findElement(cityTxt), city);
        setTextElementText(driver.findElement(addressTxt), address);
        setTextElementText(driver.findElement(zipPostalCodeTxt), postalCode);
        setTextElementText(driver.findElement(phoneNumber), phone);

        clickButton(driver.findElement(continueBtn));
        clickButton(wait.until(ExpectedConditions.elementToBeClickable(shippingMethodRdo)));
        clickButton(driver.findElement(continueShippingBtn));
        clickButton(driver.findElement(continuePaymentMethodBtn));
        clickButton(driver.findElement(continueInfo));
    }

    public void confirmOrder() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        clickButton(wait.until(ExpectedConditions.elementToBeClickable(confirmBtn)));
    }

    public void viewOrderDetails() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        clickButton(wait.until(ExpectedConditions.elementToBeClickable(orderDetailsLink)));
    }

    public String getThankYouLbl() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(thankYouLbl)).getText();
    }

    public String getSuccessMsg() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(successMsg)).getText();
    }
}
