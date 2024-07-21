package test;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITest;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import utilites.Helper;

public class TestBase
{
    public static WebDriver driver ;


    @BeforeSuite
    public static void startEnvironment(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
        driver.navigate().to("http://demo.nopcommerce.com/");
    }

    @AfterSuite
    public void stopDriver()
    {
        driver.quit();
    }
/*
    @AfterMethod
public void screenShotOnFailure(ITestResult result){
    if (result.getStatus()== ITestResult.FAILURE )
    {
        System.out.println("Failed");
        System.out.println("Taking Screenshot");
        Helper.captureScreenshot(driver,result.getName());

    }
*/
    }
