package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EmailPage extends PageBase {
    private final WebDriver driver;
    private final By emailFriendTxt = By.id("FriendEmail");
    private final By personalMessage = By.id("PersonalMessage");
    private final By submitBtn = By.xpath("//*[@id='main']/div/div/div/div[2]/form/div[2]/button");
    private final By messageGetNotification = By.xpath("//*[@id='main']/div/div/div/div[2]/div[2]");

    public EmailPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void sendMailToFriend(String friendMail, String personalMsg) {
        driver.findElement(emailFriendTxt).sendKeys(friendMail);
        driver.findElement(personalMessage).sendKeys(personalMsg);
        driver.findElement(submitBtn).click();
    }

    public  WebElement getMessageGetNotification() {
      return driver.findElement(messageGetNotification);

    }

}
