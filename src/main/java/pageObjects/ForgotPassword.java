package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class ForgotPassword extends BasePage{
	
	public ForgotPassword(WebDriver driver) {
		super(driver);
	}
	
	@CacheLookup
	@FindBy(xpath="//p[contains(.,'Forgot your password?')]")
	private WebElement txt_forgotPassword;
	
	@CacheLookup
	@FindBy(xpath="//input[@name='username']")
	private WebElement txt_username;
	
	@CacheLookup
	@FindBy(xpath="//button[normalize-space()='Reset Password']")
	private WebElement btn_reset;
	
	@CacheLookup
	@FindBy(xpath="//h6[normalize-space()='Reset Password link sent successfully']")
	private WebElement txt_msg;
	
	
	public void forgotPassword(String username) {
		txt_forgotPassword.click();
		txt_username.sendKeys(username);
		btn_reset.click();
	}
	
	
	public void infoMessage() {
		String infoMessageTxt = txt_msg.getText();
		System.out.println(infoMessageTxt);
	}
}
