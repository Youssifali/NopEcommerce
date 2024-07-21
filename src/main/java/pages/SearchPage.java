package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchPage extends PageBase {

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    private final By searchTxtBox = By.id("small-searchterms");
    private final By searchBtn = By.xpath("//*[@id=\"small-search-box-form\"]/button");
    private final By productList = By.id("ui-id-2");
    private final By productTile = By.xpath("//*[@id=\"main\"]/div/div[2]/div/div[2]/div[3]/div/div[2]/div/div/div/div/div[2]/h2/a");

    public void productSearch(String productName) {
        setTextElementText(driver.findElement(searchTxtBox), productName);
        clickButton(driver.findElement(searchBtn));
    }

    public void openProductDetailsPage() {
        clickButton(driver.findElement(productTile));
    }

    public void productSearchUsingAutoSuggest(String searchTxt) {
        setTextElementText(driver.findElement(searchTxtBox), searchTxt);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<WebElement> suggestions = driver.findElements(productList);
        if (!suggestions.isEmpty()) {
            suggestions.getFirst().click();
        }
    }
}
