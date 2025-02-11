package testCase;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class LoginPageTesting extends BaseClass{
	
	LoginPage loginPage;
	
	@Test
	public void loginPageOrangeHRM() {
		loginPage = new LoginPage(driver);
		
		loginPage.loginOrangeHRM("Admin", "admin123");
		logger.info("Enter the username and password in login page");
		String pageTitle = driver.getTitle();
		logger.info("Get the title of the page");
		Assert.assertEquals(pageTitle, "OrangeHRM");
		logger.info("Validate actual title is matching from expected title");
		String currentUrl = driver.getCurrentUrl();
		logger.info("Get the currentUrl of the page");
		Assert.assertEquals(currentUrl, "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");
		logger.info("Validate actual URL is matching from expected URL");
	}

}
