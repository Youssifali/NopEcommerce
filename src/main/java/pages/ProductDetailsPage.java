package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductDetailsPage extends PageBase {
    public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }

    public final By productNameBreadCrumb = By.xpath("//*[@id=\"main\"]/div/div[1]/ul/li[4]/strong");
    private final By emailFriendBtn = By.xpath("//*[@id=\"product-details-form\"]/div/div[1]/div[2]/div[9]/div[3]/button");
    private final By addReviewLink = By.xpath("//*[@id=\"product-details-form\"]/div/div[1]/div[2]/div[3]/div[3]/a");
    public final By productPriceLabel = By.id("price-value-4");
    private final By addToWishlistBtn = By.id("add-to-wishlist-button-4");
    private final By wishlistLink = By.xpath("//*[@id=\"bar-notification\"]/div/p/a");
    private final By addToCompareBtn = By.cssSelector("[class=\"compare-products\"]");
    private final By productComparisonLink = By.xpath("//*[@id=\"bar-notification\"]/div/p/a");
    private final By addToCartBtn = By.id("add-to-cart-button-4");
    private final By shoppingCartLink = By.xpath("//*[@id=\"bar-notification\"]/div/p/a");

    public void openSendEmail() {
        clickButton(driver.findElement(emailFriendBtn));
    }

    public void openAddReviewPage() {
        clickButton(driver.findElement(addReviewLink));
    }

    public void addProductToWishlist() {
        clickButton(driver.findElement(addToWishlistBtn));
        clickButton(driver.findElement(wishlistLink));
    }

    public void addProductToComparePage() {
        clickButton(driver.findElement(addToCompareBtn));
        clickButton(driver.findElement(productComparisonLink));
    }

    public void addProductToCart() {
        clickButton(driver.findElement(addToCartBtn));
        clickButton(driver.findElement(shoppingCartLink));
    }
    public WebElement getProductNameBreadCrumb(){
        return driver.findElement(productNameBreadCrumb);
    }
}
