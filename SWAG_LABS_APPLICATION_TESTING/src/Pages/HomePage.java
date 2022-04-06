package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	WebDriver driver;
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}	
	By mainLogo = By.className("app_logo");
	By menuBtn = By.id("react-burger-menu-btn");
	By menuList = By.xpath("//div[@class='bm-menu']");
	By cartBtn = By.className("shopping_cart_link");
	By selectContainer = By.xpath("//select[@class='product_sort_container']");
	By A_to_Z = By.xpath("//option[@value='az']");
	By Z_to_A = By.xpath("//option[@value='za']");
	By Low_to_High = By.xpath("//option[@value='lohi']");
	By High_to_Low = By.xpath("//option[@value='hilo']");
	By itemName1 = By.xpath("//div[@class='inventory_item_name']");
	By itemName2 = By.xpath("//div[@class='inventory_item_name']");
	By itemName3 = By.xpath("//div[@class='inventory_item_name']");
	By itemName4 = By.xpath("//div[@class='inventory_item_name']");
	By itemName5 = By.xpath("//div[@class='inventory_item_name']");
	By itemName6 = By.xpath("//div[@class='inventory_item_name']");
    public void checkLogo(String logo) {
		driver.findElement(mainLogo).isDisplayed();
	}
	public void clickMenuBtn() {
		driver.findElement(menuBtn).click();
	}
	public String displayMenuList() {
		return  driver.findElement(menuList).getText();
	}
	public void clickCartBtn() {
		driver.findElement(cartBtn).click();
	}
	public void clickSelectContainer() {
		driver.findElement(selectContainer).click();
	}
	public String displayContainer() {
		return  driver.findElement(selectContainer).getText();
	}
	public void click_AtoZ() {
		driver.findElement(A_to_Z).click();
	}
	public void click_ZtoA() {
		driver.findElement(Z_to_A).click();
	}
	public void click_LowtoHigh() {
		driver.findElement(Low_to_High).click();
	}
	public void click_HightoLow() {
		driver.findElement(High_to_Low).click();
	}
	public void clickItem1() {
		driver.findElement(itemName1).click();
	}
	public void clickItem2() {
		driver.findElement(itemName2).click();
	}
	public void clickItem3() {
		driver.findElement(itemName3).click();
	}
	public void clickItem4() {
		driver.findElement(itemName4).click();
	}
	public void clickItem5() {
		driver.findElement(itemName5).click();
	}
	public void clickItem6() {
		driver.findElement(itemName6).click();
	}
}
