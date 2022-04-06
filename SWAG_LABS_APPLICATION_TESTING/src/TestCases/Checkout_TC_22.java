package TestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import Pages.CheckoutPage;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.ProductPage;
import Pages.YourCartPage;

public class Checkout_TC_22 {
static WebDriver driver;
    
    public static void main(String[] args) throws InterruptedException {

		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extent.html");            
        // create ExtentReports and attach reporter(s)
      ExtentReports extent = new ExtentReports();
        extent.attachReporter(htmlReporter);  
		
		
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
        driver = new ChromeDriver();
        
        ExtentTest test = extent.createTest("Checkout_TC_22", "Sample description");
        
        driver.get("https://www.saucedemo.com/");
        
        
	LoginPage login = new LoginPage(driver);
    login.enterUserName("standard_user");
    login.enterPassword("secret_sauce");
    login.clickLogin();
    
    Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
    
    HomePage home = new HomePage(driver);
    home.clickItem1();
    
    Thread.sleep(1000);
    Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory-item.html?id=4");
    
    ProductPage product = new ProductPage(driver);
    product.click_product1_atc();
    
    Thread.sleep(1000);
    
    home.clickCartBtn();
    
    Thread.sleep(1000);
    
    YourCartPage cart = new YourCartPage(driver);
    cart.clickCheckout();
    
    CheckoutPage checkout = new CheckoutPage(driver);
    checkout.enterFirstName("Smith");
    
    extent.flush();
    driver.quit();

    }
    
}
