package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	@CacheLookup
	@FindBy(xpath="//input[@name='username']")
	private WebElement txt_username;
	
	@CacheLookup
	@FindBy(xpath="//input[@name='password']")
	private WebElement txt_password;
	
	@CacheLookup
	@FindBy(xpath="//button[@type='submit']")
	private WebElement btn_login;
	
	
	
	public void loginOrangeHRM(String username, String password) {
		txt_username.sendKeys(username);
		txt_password.sendKeys(password);
		btn_login.click();
	}

}
