package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class AddToCartPage extends PageBase {
    public AddToCartPage(WebDriver driver) {
        super(driver);
    }

    By checkoutBtn = By.id("checkout");
    By termsCheckBox = By.id("termsofservice");
    By removeIcon = By.className("remove-btn");
    By qty = By.xpath("//*[contains(@id, 'itemquantity')]");
    By totalLbl = By.className("product-subtotal");

    public void removeProductFromCart() {
        clickButton(driver.findElement(removeIcon));
    }

    public void updateQuantity(String quantity) {
        WebElement qtyElement =  getQty() ;
        qtyElement.click();
        qtyElement.sendKeys(Keys.CONTROL + "a");
        qtyElement.sendKeys(Keys.DELETE);
        setTextElementText(qtyElement, quantity);
        qtyElement.sendKeys(Keys.ENTER);
    }

    public void openCheckoutPage() {
        clickButton(driver.findElement(termsCheckBox));
        clickButton(driver.findElement(checkoutBtn));
    }
    public WebElement getQty() {
        return driver.findElement(qty);
    }

    public WebElement getTotalLbl() {
        return driver.findElement(totalLbl);
    }
}
