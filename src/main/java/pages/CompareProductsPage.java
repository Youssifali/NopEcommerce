package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CompareProductsPage extends PageBase {
    private final WebDriver driver;
    private final By clearListBtn = By.xpath("//*[@id='main']/div/div[2]/div/div[2]/a");
    private final By compareTable = By.xpath("//*[@id='main']/div/div[2]/div/div[2]/div/table");
    private final By allRows = By.tagName("tr");
    private final By allCol = By.tagName("td");
    private final By noDataLbl = By.xpath("//*[@id='main']/div/div[2]/div/div[2]/div");
    private final By firstProductName = By.linkText("Asus N551JK-XO076H Laptop");
    private final By secondProductName = By.linkText("Apple MacBook Pro 13-inch");

    public CompareProductsPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void clearCompareList() {
        driver.findElement(clearListBtn).click();
    }

    public void compareProducts() {
        List<WebElement> rows = driver.findElements(allRows);
        System.out.println(rows.size());

        for (WebElement row : rows) {
            System.out.println(row.getText() + "\t");
            List<WebElement> cols = row.findElements(allCol);
            for (WebElement col : cols) {
                System.out.println(col.getText() + "\t");
            }
        }
    }
    public WebElement getFirstProductName(){
        return driver.findElement(firstProductName);
    }
    public WebElement getSecondProductName(){
        return driver.findElement(secondProductName);
    }
    public WebElement getNoDataLbl(){
        return driver.findElement(noDataLbl);
    }
}
