package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {
WebDriver driver;
	public CheckoutPage(WebDriver driver) {
		this.driver = driver;
	}
	By cancelBtn = By.id("cancel");
	By continueBtn = By.id("continue");
	By firstName = By.id("first-name");
	By lastName = By.id("last-name");
	By postalCode = By.id("postal-code");
	
	public void clickCancelBtn() {
		driver.findElement(cancelBtn).click();
	}
	public void clickContinueBtn() {
		driver.findElement(continueBtn).click();
	}
	public void enterFirstName(String first_name) {
		driver.findElement(firstName).sendKeys(first_name);
	}
	public void enterLastName(String last_name) {
		driver.findElement(lastName).sendKeys(last_name);
	}
	public void enterPostalCode(String code) {
		driver.findElement(postalCode).sendKeys(code);
	}
	
}