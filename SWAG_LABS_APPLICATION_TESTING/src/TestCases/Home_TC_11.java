package TestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.ProductPage;

public class Home_TC_11 {
	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {

		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extent.html");            
        // create ExtentReports and attach reporter(s)
      ExtentReports extent = new ExtentReports();
        extent.attachReporter(htmlReporter);  
		
		
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
        driver = new ChromeDriver();
        
        ExtentTest test = extent.createTest("Home_TC_11", "Sample description");
        
        driver.get("https://www.saucedemo.com/");
        
        LoginPage login = new LoginPage(driver);
        login.enterUserName("standard_user");
        login.enterPassword("secret_sauce");
        login.clickLogin();
        
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
        
        HomePage home = new HomePage(driver);
        home.clickItem1();
        
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory-item.html?id=4");
       
        Thread.sleep(1000);
        
        ProductPage product = new ProductPage(driver);
        product.click_product1_atc();
        Thread.sleep(1000);
        product.click_product1_remove();
       
        extent.flush();
       driver.quit();
       
	}
}