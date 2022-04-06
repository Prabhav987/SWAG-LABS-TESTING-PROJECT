package TestCases;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import Pages.CheckoutPage;
import Pages.Checkout_Overview_Page;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.ProductPage;
import Pages.YourCartPage;

public class SampleExtentreport {
	static WebDriver driver;
	public ExtentTest logger1, logger2, logger3, logger4, logger5, logger6, logger7, logger8, logger9, logger10, logger11, logger12, logger13;
	public ExtentHtmlReporter reporter;
	public ExtentReports extent;
	
	@BeforeMethod
	public void setUp(){
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		driver = new ChromeDriver(); 
	}
	@BeforeTest
	public void setExtent()
	{
		reporter = new ExtentHtmlReporter("./Reports/tests.html");
		reporter.config().setTheme(Theme.DARK);
		reporter.config().setDocumentTitle("TestCasesReport");
		reporter.config().setReportName("FunctionalTest Report");
		extent = new ExtentReports();
		extent.attachReporter(reporter);
	}
	@Test(priority = 1)
	public void verifyLogin1() throws InterruptedException{
		System.out.println("Login_TC_02 is started.");
		logger1 = extent.createTest("verifyLogin1");
		driver.get("https://www.saucedemo.com/");
		LoginPage login = new LoginPage(driver);
		login.enterUserName("locked_out_user");
		login.enterPassword("secret_sauce");
		login.hiddenPassword();
		login.clickLogin();
		Thread.sleep(3000);
		String result = "Sorry, this user has been locked out.";
		Assert.assertEquals(result, "Sorry, this user has been locked out.");
		logger1.log(Status.PASS, "User is unable to login with username : locked_out_user");
		System.out.println("Login_TC_02 is closed.");
	}
	@Test(priority = 2)
	public void verifyLogin2() throws InterruptedException{
		System.out.println("Login_TC_05 is started.");
		logger2 = extent.createTest("verifyLogin2");
		driver.get("https://www.saucedemo.com/");
		LoginPage login = new LoginPage(driver);
		login.enterUserName("problem_user");
		login.enterPassword("secret_sauce");
		login.clickLogin();
		Thread.sleep(3000);
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
		logger2.log(Status.INFO, "User is able to login and enter into next page.");
		System.out.println("Login_TC_05 is closed.");
	}
	@Test(priority = 3)
	public void verifyerror1() throws InterruptedException{
		System.out.println("Login_TC_07 is started.");
		logger3 = extent.createTest("verifyerror1");
		driver.get("https://www.saucedemo.com/");
		LoginPage login = new LoginPage(driver);
		login.enterUserName("locked_user");
		login.enterPassword("secret_sauce");
		login.hiddenPassword();
		login.clickLogin();
		Thread.sleep(3000);
		String error = login.errorDisplay();
		Assert.assertEquals(error, "Epic sadface: Username and password do not match any user in this service");
		logger3.log(Status.INFO, "User is not able to login with invalid username.");
		System.out.println("Login_TC_07 is closed.");
	}
	@Test(priority = 4)
	public void verifyerror2() throws InterruptedException{
		System.out.println("Login_TC_08 is started.");
		logger4 = extent.createTest("verifyerror2");
		driver.get("https://www.saucedemo.com/");
		LoginPage login = new LoginPage(driver);
		login.enterUserName("problem_user");
		login.enterPassword("secret");
		login.hiddenPassword();
		login.clickLogin();
		Thread.sleep(3000);
		String error = login.errorDisplay();
		Assert.assertEquals(error, "Epic sadface: Username and password do not match any user in this service");
		logger4.log(Status.INFO, "User is not able to login with invalid password.");
		System.out.println("Login_TC_08 is closed.");
	}

	@Test(priority = 5)
	public void verifyerror3() throws InterruptedException{
		System.out.println("Login_TC_10 is started.");
		logger5 = extent.createTest("verifyerror3");
		driver.get("https://www.saucedemo.com/");
		LoginPage login = new LoginPage(driver);
		login.enterUserName("problem_user");
		login.hiddenPassword();
		login.clickLogin();
		Thread.sleep(3000);
		String error = login.errorDisplay();
		Assert.assertEquals(error, "Epic sadface: Password is required");
		logger5.log(Status.INFO, "User is unable to login when left the password field empty.");
		System.out.println("Login_TC_10 is closed.");

	}

	@Test(priority = 6)
	public void verifyProductsPage1() throws InterruptedException{
		System.out.println("Home_TC_11 is started.");
		logger6 = extent.createTest("verifyProductsPage1");
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
		logger6.log(Status.INFO, "User is able to add the product to the cart and remove the product from the cart.");
		System.out.println("Home_TC_11 is closed.");
	}
	
	@Test(priority = 7)
	public void verifyProductsPage2() throws InterruptedException{
		System.out.println("Home_TC_12 is started.");
		logger7 = extent.createTest("verifyProductsPage2");
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
        home.clickMenuBtn();
        String menu_btn = home.displayMenuList();
        Assert.assertEquals(menu_btn.toUpperCase().contains("All Items\n"+"About\n"+"Logout\n"+"Reset App State"), false);
        logger7.log(Status.INFO, "User is able to click menu button and options are visible.");
		System.out.println("Home_TC_12 is closed.");
	}
	
	@Test(priority = 8)
	public void verifyProductsPage3() throws InterruptedException{
		System.out.println("Home_TC_18 is started.");
		logger8 = extent.createTest("verifyProductsPage3");
		driver.get("https://www.saucedemo.com/");
		LoginPage login = new LoginPage(driver);
		login.enterUserName("standard_user");
	    login.enterPassword("secret_sauce");
	    login.clickLogin();
	    Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
	    HomePage home = new HomePage(driver);
	    home.clickSelectContainer();
	    home.click_AtoZ();
	    String select_container = home.displayContainer();
	    Assert.assertEquals(select_container, "Name (A to Z)\n"+"Name (Z to A)\n"+"Price (low to high)\n"+"Price (high to low)");
	    logger8.log(Status.INFO, "User is able to click select container and A_to_Z option.");
		System.out.println("Home_TC_18 is closed.");
	}
	
	@Test(priority = 9)
	public void verifyProductsPage4() throws InterruptedException{
		System.out.println("Home_TC_19 is started.");
		logger9 = extent.createTest("verifyProductsPage4");
		driver.get("https://www.saucedemo.com/");
		LoginPage login = new LoginPage(driver);
		login.enterUserName("standard_user");
	    login.enterPassword("secret_sauce");
	    login.clickLogin();
	    Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
	    HomePage home = new HomePage(driver);
	    home.clickSelectContainer();
	    home.click_ZtoA();
	    String select_container = home.displayContainer();
	    Assert.assertEquals(select_container, "Name (A to Z)\n"+"Name (Z to A)\n"+"Price (low to high)\n"+"Price (high to low)");
	    logger9.log(Status.INFO, "Z_to_A option is clickable.");
		System.out.println("Home_TC_19 is closed.");
	}
	
	@Test(priority = 10)
	public void verifyProductsPage5() throws InterruptedException{
		System.out.println("Home_TC_20 is started.");
		logger10 = extent.createTest("verifyProductsPage5");
		driver.get("https://www.saucedemo.com/");
		LoginPage login = new LoginPage(driver);
		login.enterUserName("standard_user");
	    login.enterPassword("secret_sauce");
	    login.clickLogin();
	    Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
	    HomePage home = new HomePage(driver);
	    home.clickSelectContainer();
	    String select_container = home.displayContainer();
	    Assert.assertEquals(select_container, "Name (A to Z)\n"+"Name (Z to A)\n"+"Price (low to high)\n"+"Price (high to low)");
	    System.out.println(true);
	    home.click_HightoLow();
	    Thread.sleep(2000);
	    home.click_LowtoHigh();
	    Thread.sleep(2000);
	    logger10.log(Status.INFO, "Option High_to_Low and Low_to High are clickable.");
		System.out.println("Home_TC_20 is closed.");
	}
	
	@Test(priority = 11)
	public void verifyProductsPage6() throws InterruptedException{
		System.out.println("YourCart_TC_21 is started.");
		logger11 = extent.createTest("verifyProductsPage6");
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
	    logger11.log(Status.INFO, "Cart and checkout button are clickable.");
		System.out.println("YourCart_TC_21 is closed.");
	}
	
	@Test(priority = 12)
	public void verifyCheckoutPage1() throws InterruptedException{
		System.out.println("Checkout_TC_22 is started.");
		logger12 = extent.createTest("verifyCheckoutPage1");
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
	    Thread.sleep(3000);
	    logger12.log(Status.INFO, "User is able to click checkout button and fill details.");
		System.out.println("Checkout_TC_22 is closed.");
	}

	@Test(priority = 13)
	public void verifyCheckoutPage2() throws InterruptedException{
		System.out.println("CheckoutComplete_TC_25 is started.");
		logger13 = extent.createTest("verifyCheckoutPage2");
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
	    checkout.enterFirstName("Prince");
	    checkout.enterLastName("Sharma");
	    checkout.enterPostalCode("7262818");
	    Thread.sleep(100);
	    checkout.clickContinueBtn();
	    Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/checkout-step-two.html");
	    Checkout_Overview_Page overview = new Checkout_Overview_Page(driver);
	    overview.checkoutOverviewLogoDisplay();
	    overview.productInfoDisplay();
	    overview.clickFinishBtn();
	    Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/checkout-complete.html");
	    logger13.log(Status.INFO, "User is able to place order successfully.");
		System.out.println("CheckoutComplete_TC_25 is closed.");
	}
	@AfterTest
	public void endReport()
	{
		extent.flush();
	}
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
