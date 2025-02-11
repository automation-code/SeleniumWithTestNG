package example03.Assertions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestngUsingHardAssert {

	WebDriver driver;

	@BeforeTest
	public void BeforeTestCaseRunning() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Test
	public void validationUsingHardAssert() {
		driver.get("https://www.google.com/");
		String actualTitle = driver.getTitle();
		String expectedTitle = "Google";
		Assert.assertEquals(actualTitle, expectedTitle, "Page title is matching.");
		Assert.assertNotEquals(actualTitle, "Google !!!", "Page title is not matching.");
		boolean logoImg = driver.findElement(By.xpath("//img[@alt='Google']")).isDisplayed();
		Assert.assertTrue(logoImg, "Page logo is displaying.");
		boolean logoImgDisplayed = driver.findElement(By.xpath("//img[@alt='Google']")).isDisplayed();
		Assert.assertFalse(logoImgDisplayed, "Page logo is not displaying.");
	}

	@AfterTest
	public void AfterTestCaseRunning() {
		driver.close();
	}

}
