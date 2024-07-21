package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderDetailsPage extends PageBase{

    public OrderDetailsPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//*[@id=\"main\"]/div/div/div/div[1]/a[2]")
    WebElement pdfInvoiceLink;
    @FindBy(xpath = "//*[@id=\"main\"]/div/div/div/div[1]/a[1]")
    WebElement printInvoiceLink;
    public void printOrderDetails(){
        clickButton(printInvoiceLink);
    }
    public void DownloadPDF(){
        clickButton(pdfInvoiceLink);
    }

}









