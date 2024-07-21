package test;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductDetailsPage;
import pages.SearchPage;
import utilites.Wait;
import java.time.Duration;

public class ChangeCurrencyTest extends TestBase {
    HomePage homeObj;
    ProductDetailsPage productDetailsObj;
    String productName = "Apple MacBook Pro 13-inch";
    SearchPage searchObj;
    ProductDetailsPage detailsObj;

    @Test(priority = 1)
    public void userCanChangeCurrency() {
        homeObj = new HomePage(driver);
        homeObj.changeCurrency();
        Wait.waitForPageToLoad(driver, Duration.ofSeconds(10));

        // Verify currency change
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(
                By.id("customerCurrency"), "Euro"));

        System.out.println("Currency changed to Euro.");
    }

    @Test(priority = 2)
    public void UserCanSearchWithAutoSuggest() {
        try {
            searchObj = new SearchPage(driver);
            searchObj.productSearchUsingAutoSuggest("MacB");
            detailsObj = new ProductDetailsPage(driver);

            Wait.waitForPageToLoad(driver, Duration.ofSeconds(10));

            String productNameBreadcrumb = detailsObj.getProductNameBreadCrumb().getText();
            String productPriceLabel = detailsObj.getProductNameBreadCrumb().getText();

            System.out.println("Product Name: " + productNameBreadcrumb);
            System.out.println("Product Price: " + productPriceLabel);

            Assert.assertEquals(productNameBreadcrumb, productName);
            Assert.assertTrue(productPriceLabel.contains("€"), "Price label does not contain € symbol");
        } catch (Exception e) {
            System.out.println("Error occurred: " + e.getMessage());
        }
    }
}
