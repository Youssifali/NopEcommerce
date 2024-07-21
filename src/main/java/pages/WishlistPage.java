package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WishlistPage extends PageBase {

    public WishlistPage(WebDriver driver) {
        super(driver);
    }

    public final By productCell = By.xpath("//*[@id=\"main\"]/div/div/div/div[2]/div[1]/form/div[1]/table/tbody/tr/td[4]");
    public final By wishlistHeader = By.xpath("//*[@id=\"main\"]/div/div/div/div[1]/h1");
    private final By updateBtn = By.id("updatecart");
    private final By removeFromCartBtn = By.xpath("//*[@id=\"main\"]/div/div/div/div[2]/div[1]/form/div[1]/table/tbody/tr/td[8]/button");
    public final By emptyCartLbl = By.xpath("//*[@id=\"main\"]/div/div/div/div[2]/div");

    public void removeProductFromWishlist() {
        clickButton(driver.findElement(removeFromCartBtn));
    }
    public WebElement getProductCell(){
        return driver.findElement(productCell);
    }
    public WebElement getWishlistHeader() {
        return driver.findElement(wishlistHeader);
    }
    public WebElement getEmptyCartLbl() {
        return driver.findElement(emptyCartLbl);
    }
}
