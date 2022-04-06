package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	 public WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	By headLogo = By.className("login_logo");
	By uname = By.id("user-name");
	By pswrd = By.id("password");
	By loginBtn = By.id("login-button");
	By errorMsg = By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3");
	
	public String checkLogo() {
		return  driver.findElement(headLogo).getText();
	}
	public void enterUserName(String user) {
		driver.findElement(uname).sendKeys(user);
	}
	public void hiddenPassword() {
		driver.findElement(pswrd).isEnabled();
	}
	public void enterPassword(String pass) {
		driver.findElement(pswrd).sendKeys(pass);
	}
	public void clickLogin() {
		driver.findElement(loginBtn).click();
	}
	public String errorDisplay() {
		return driver.findElement(errorMsg).getText();
		}
}
