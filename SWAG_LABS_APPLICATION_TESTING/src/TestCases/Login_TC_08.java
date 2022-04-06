package TestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import Pages.LoginPage;

public class Login_TC_08 {
static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extent.html");            
        // create ExtentReports and attach reporter(s)
      ExtentReports extent = new ExtentReports();
        extent.attachReporter(htmlReporter);  
		
		
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
        driver = new ChromeDriver();
        
        ExtentTest test = extent.createTest("Login_TC_08", "Sample description");
        
        driver.get("https://www.saucedemo.com/");
        
        LoginPage login = new LoginPage(driver);
        
        login.enterUserName("problem_user");
        login.enterPassword("secret");
        login.hiddenPassword();
        login.clickLogin();
        
        
        String error = login.errorDisplay();
        Assert.assertEquals(error, "Epic sadface: Username and password do not match any user in this service");
        System.out.println(true);
        
        Thread.sleep(2000);
        
        extent.flush();
	driver.quit();
	}

}

