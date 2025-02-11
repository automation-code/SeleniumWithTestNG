package example16.ExtentReports;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCaseER {

	WebDriver driver;

	@BeforeClass
	public void lunchBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Test(priority = 1)
	public void loginPage() {
		driver.get("https://practicetestautomation.com/practice-test-login/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("student");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Password123");
		driver.findElement(By.xpath("//button[@id='submit']")).click();
	}

	@Test(priority = 2)
	public void verifySuccessfullyLogin() {
		String msgConfirm = driver.findElement(By.xpath("//h1[contains(text(),'Logged In Successfully')]")).getText();
		Assert.assertEquals(msgConfirm, "Logged In Successfully");
	}

	@Test(priority = 3)
	public void verifyPageTitle() {
		Assert.assertEquals(driver.getTitle(), "Logged In Successfully | Practice Test Automation");
	}

	@Test(priority = 4)
	public void verifyCurrentUrl() {
		String expectedUrl = "https://practicetestautomation.com/logged-in-successfully/";
		Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);
	}

	@Test(priority = 5)
	public void verifyLogoutFunctionality() {
		driver.findElement(By.linkText("Log out")).click();
		String loginTxt = driver.findElement(By.xpath("//h2[contains(text(),'Test login')]")).getText();
		Assert.assertEquals("Test login", loginTxt);
	}

	@Test(priority = 6)
	public void invalidUserLogin() {
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("student2024");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Password123");
		driver.findElement(By.xpath("//button[@id='submit']")).click();
		Assert.assertEquals(driver.getTitle(), "Logged In Successfully | Practice Test Automation");
	}

	@AfterMethod
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
