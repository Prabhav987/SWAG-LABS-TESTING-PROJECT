package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage {
	WebDriver driver;
	
	public ProductPage(WebDriver driver) {
		this.driver = driver;
	}
	 By product1_atc = By.id("add-to-cart-sauce-labs-backpack");
	 By product1_remove = By.id("remove-sauce-labs-backpack");	
	 By product2_atc = By.id("add-to-cart-sauce-labs-bike-light");
	 By product2_remove = By.id("remove-sauce-labs-bike-light");
	 By product3_atc = By.id("add-to-cart-sauce-labs-bolt-t-shirt");
	 By product3_remove = By.id("remove-sauce-labs-bolt-t-shirt");
	 By product4_atc = By.id("add-to-cart-sauce-labs-fleece-jacket");
	 By product4_remove = By.id("remove-sauce-labs-fleece-jacket");
	 By product5_atc = By.id("add-to-cart-sauce-labs-onesie");
	 By product5_remove = By.id("remove-sauce-labs-onesie");
	 By product6_atc = By.id("add-to-cart-test.allthethings()-t-shirt-(red)");
	 By product6_remove = By.id("remove-test.allthethings()-t-shirt-(red)");
	
	 public void click_product1_atc() {
		 driver.findElement(product1_atc).click();
	 }
	 public void click_product1_remove() {
		 driver.findElement(product1_remove).click();
	 }
	 public void click_product2_atc() {
		 driver.findElement(product2_atc).click();
	 }
	 public void click_product2_remove() {
		 driver.findElement(product2_remove).click();
	 }
	 public void click_product3_atc() {
		 driver.findElement(product3_atc).click();
	 }
	 public void click_product3_remove() {
		 driver.findElement(product3_remove).click();
	 }
	 public void click_product4_atc() {
		 driver.findElement(product4_atc).click();
	 }
	 public void click_product4_remove() {
		 driver.findElement(product4_remove).click();
	 }
	 public void click_product5_atc() {
		 driver.findElement(product5_atc).click();
	 }
	 public void click_product5_remove() {
		 driver.findElement(product5_remove).click();
	 }
	 public void click_product6_atc() {
		 driver.findElement(product6_atc).click();
	 }
	 public void click_product6_remove() {
		 driver.findElement(product6_remove).click();
	 }

}