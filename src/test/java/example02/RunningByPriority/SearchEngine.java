package example02.RunningByPriority;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SearchEngine {

	WebDriver driver;

	@BeforeTest
	public void BeforeTestCaseRunning() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Test(priority = 2)
	public void googleTestCase() {
		driver.get("https://www.google.com/");
		String pageTitle = driver.getTitle();
		System.out.println(pageTitle);
	}

	@Test(priority = 1)
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

	@AfterTest
	public void AfterTestCaseRunning() {
		driver.close();
	}

}
