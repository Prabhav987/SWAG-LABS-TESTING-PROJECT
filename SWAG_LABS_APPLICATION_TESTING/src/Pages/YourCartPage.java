package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class YourCartPage {
WebDriver driver;
	public YourCartPage(WebDriver driver) {
		this.driver = driver;
	}
	By continueShop = By.id("continue-shopping");
	By checkout = By.id("checkout");
	
	public void clickContinueShop() {
		driver.findElement(continueShop).click();
	}
	public void clickCheckout() {
		driver.findElement(checkout).click();
	}
}
