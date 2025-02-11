package testCase;

import org.testng.annotations.Test;
import pageObjects.ForgotPassword;
import testBase.BaseClass;

public class ForgotPasswordTesting extends BaseClass{

	@Test
	public void verifyForgotPassword() {
		
		ForgotPassword fp = new ForgotPassword(driver);
		
		logger.info("Enter the username for resetting the password");
		fp.forgotPassword("Admin");
		logger.info("Get the successfully message to reset link");
		fp.infoMessage();
	}
}
