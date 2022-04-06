package TestCases;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Extent_Report{
	
	@Test
	public void loginTest() {
		
	System.out.println("loginPage");
	ExtentHtmlReporter reporter = new ExtentHtmlReporter("./Reports/tests.html");
	ExtentReports extent = new ExtentReports();
	extent.attachReporter(reporter);
	
	ExtentTest logger = extent.createTest("Login_TC_02");
	logger.log(Status.INFO, "loginPage");
	extent.flush();

	ExtentTest logger2 = extent.createTest("Login_TC_05");
	logger2.log(Status.INFO, "loginPage");
	extent.flush();
	
	ExtentTest logger3 = extent.createTest("Login_TC_07");
	logger3.log(Status.INFO, "loginPage");
	extent.flush();
	
	ExtentTest logger4 = extent.createTest("Login_TC_08");
	logger4.log(Status.INFO, "loginPage");
	extent.flush();

	ExtentTest logger5 = extent.createTest("Login_TC_10");
	logger5.log(Status.INFO, "loginPage");
	extent.flush();
	
	System.out.println("HomePage");
	ExtentTest logger6 = extent.createTest("HomePage_TC_11");
	logger6.log(Status.INFO, "HomePage");
	extent.flush();
	
	ExtentTest logger7 = extent.createTest("HomePage_TC_12");
	logger7.log(Status.INFO, "HomePage");
	extent.flush();
	
	ExtentTest logger8 = extent.createTest("HomePage_TC_18");
	logger8.log(Status.INFO, "HomePage");
	extent.flush();
	
	ExtentTest logger9 = extent.createTest("HomePage_TC_19");
	logger9.log(Status.INFO, "HomePage");
	extent.flush();
	
	ExtentTest logger10 = extent.createTest("HomePage_TC_20");
	logger10.log(Status.INFO, "HomePage");
	extent.flush();
	
	System.out.println("YourCartPage");
	ExtentTest logger11 = extent.createTest("YourCart_TC_21");
	logger11.log(Status.INFO, "YourCartPage");
	extent.flush();
	
	System.out.println("CheckoutPage");
	ExtentTest logger12 = extent.createTest("Checkout_TC_22");
	logger12.log(Status.INFO, "CheckoutPage");
	extent.flush();
	
	System.out.println("CheckoutCompletePage");
	ExtentTest logger13 = extent.createTest("CheckoutComplete_TC_25");
	logger13.log(Status.INFO, "CheckoutCompletePage");
	extent.flush();
	}
	
}