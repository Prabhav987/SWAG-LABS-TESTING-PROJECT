package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Checkout_Overview_Page {
WebDriver driver;	
	public Checkout_Overview_Page(WebDriver driver) {
		this.driver = driver;
	}
	By checkoutOverviewLogo = By.xpath("//*[@id=\"header_container\"]/div[2]/span");
	By ProductInfo = By.className("summary_info");
	By finishBtn = By.id("finish");
	
	public void checkoutOverviewLogoDisplay() {
		driver.findElement(checkoutOverviewLogo).isDisplayed();
	}
	public void productInfoDisplay() {
		driver.findElement(ProductInfo).isDisplayed();
	}
	public void clickFinishBtn() {
		driver.findElement(finishBtn).click();
	}
}
