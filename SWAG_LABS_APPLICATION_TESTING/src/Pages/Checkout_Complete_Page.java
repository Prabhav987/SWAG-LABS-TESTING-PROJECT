package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Checkout_Complete_Page {
WebDriver driver;	
	public Checkout_Complete_Page(WebDriver driver) {
		this.driver = driver;
	}
	By checkoutCompleteLogo = By.xpath("//*[@id=\"header_container\"]/div[2]/span");
	By thankYou = By.id("checkout_complete_container");
	By backHomeBtn = By.id("back-to-products");
	
	public void checkoutCompleteLogoDisplay(String completeLogo) {
		driver.findElement(checkoutCompleteLogo).isDisplayed();
	}
	public void thankyouDisplay(String thankyouDisplay) {
		driver.findElement(thankYou).isDisplayed();
	}
	public void clickBackHomeBtn() {
		driver.findElement(backHomeBtn).click();
	}
}
