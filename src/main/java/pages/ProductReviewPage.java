package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductReviewPage extends PageBase {

    public ProductReviewPage(WebDriver driver) {
        super(driver);
    }

    private final By reviewTitleTxt = By.id("AddProductReview_Title");
    private final By reviewTxt = By.id("AddProductReview_ReviewText");
    private final By submitBtn = By.id("add-review");
    private final By rating = By.id("addproductrating_5");
    public final By reviewNotification = By.xpath("//*[@id=\"bar-notification\"]/div");
    private final By closeBtn = By.xpath("//*[@id=\"bar-notification\"]/div/span");

    public void addProductReview(String reviewTitle, String reviewMessage) {
        setTextElementText(driver.findElement(reviewTitleTxt), reviewTitle);
        setTextElementText(driver.findElement(reviewTxt), reviewMessage);
        clickButton(driver.findElement(rating));
        clickButton(driver.findElement(submitBtn));
    }

    public void closeNotification() {
        clickButton(driver.findElement(closeBtn));
    }
    public WebElement getReviewNotification(){
        return driver.findElement(reviewNotification);
    }
}
