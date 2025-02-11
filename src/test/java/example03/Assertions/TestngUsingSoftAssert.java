package example03.Assertions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestngUsingSoftAssert {

	WebDriver driver;

	@BeforeTest
	public void BeforeTestCaseRunning() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Test
	public void validationUsingSoftAssert() {
		driver.get("https://www.google.com/");
		String actualTitle = driver.getTitle();
		String expectedTitle = "Google";

		SoftAssert softAssert = new SoftAssert();

		softAssert.assertEquals(actualTitle, expectedTitle, "Page title is matching.");
		softAssert.assertNotEquals(actualTitle, "Google !!!", "Page title is not matching.");
		boolean logoImg = driver.findElement(By.xpath("//img[@alt='Google']")).isDisplayed();
		softAssert.assertTrue(logoImg, "Page logo is displaying.");
		boolean logoImgDisplayed = driver.findElement(By.xpath("//img[@alt='Google']")).isDisplayed();
		softAssert.assertFalse(logoImgDisplayed, "Page logo is not displaying.");

		// It is throwing the exception when using the assertAll() function,
		// Otherwise all assertion will passed without throwing exception.
		softAssert.assertAll();
	}

	@AfterTest
	public void AfterTestCaseRunning() {
		driver.close();
	}

}
