package TestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import Pages.LoginPage;


public class Login_TC_02{
	static WebDriver driver;
    public static void main(String[] args) throws InterruptedException {

	
	System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
    driver = new ChromeDriver();
    driver.get("https://www.saucedemo.com/");

	
	
		LoginPage login = new LoginPage(driver);
		login.enterUserName("locked_out_user");
		login.enterPassword("secret_sauce");
		login.hiddenPassword();
		login.clickLogin();
		

		Assert.assertTrue(true, "Sorry, this user has been locked out.");
	
		driver.quit();

}

}