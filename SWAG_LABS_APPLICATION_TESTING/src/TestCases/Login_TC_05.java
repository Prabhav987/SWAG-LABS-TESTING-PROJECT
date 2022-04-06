package TestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import Pages.CheckoutPage;
import Pages.Checkout_Complete_Page;
import Pages.Checkout_Overview_Page;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.ProductPage;
import Pages.YourCartPage;

public class Login_TC_05 {
static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extent.html");            
        // create ExtentReports and attach reporter(s)
      ExtentReports extent = new ExtentReports();
        extent.attachReporter(htmlReporter);  
		
		
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
        driver = new ChromeDriver();
        
        ExtentTest test = extent.createTest("Login_TC_05", "Sample description");
        
        driver.get("https://www.saucedemo.com/");
        
        LoginPage login = new LoginPage(driver);
                
        login.enterUserName("problem_user");
        login.enterPassword("secret_sauce");
        login.clickLogin();
        
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
       
        Thread.sleep(10000);
        
        extent.flush();
        driver.quit();
        
	}

}
