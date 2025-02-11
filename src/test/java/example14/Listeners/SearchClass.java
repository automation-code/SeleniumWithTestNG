package example14.Listeners;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

@Listeners({ITestListenerClass.class})
public class SearchClass {
	
	WebDriver driver;
	
	@BeforeTest
	public void BeforeTestCaseRunning() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@Test(priority = 1)
	public void googleTestCase() {
		driver.get("https://www.google.com/");
		String pageTitle = driver.getTitle();
		System.out.println(pageTitle);
	}
	
	@Test(priority = 2)
	public void bingTestCase() {
		driver.get("https://www.bing.com/");
		String pageTitle = driver.getTitle();
		System.out.println(pageTitle);
	}
	
	@Test(priority = 3)
	public void yandexTestCase() {
		driver.get("https://yandex.com/");
		String pageTitle = driver.getTitle();
		System.out.println(pageTitle);
	}
	
	@Test(priority = 4)
	public void onTestFailureTestCase() {
		driver.get("https://yandex.com/");
			Assert.assertTrue(false);
	}
	
	@Test(priority = 5, timeOut = 10)
	public void onTestTimeoutTestCase() {
		driver.get("https://yandex.com/");
	}
	
	@Test(priority = 6, dependsOnMethods = "onTestTimeoutTestCase")
	public void onTestSkippedTestCase() {
		driver.get("https://yandex.com/");
	}
	
	@AfterTest
	public void AfterTestCaseRunning() {
		driver.close();
	}

}
