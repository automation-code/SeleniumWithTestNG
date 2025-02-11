package example12.ParallelExecutions;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ExecutionClass2 {

WebDriver driver;
	
	@BeforeTest
	public void BeforeTestCaseRunning() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@Test
	public void facebookTestCase() {
		driver.get("https://www.facebook.com/");
		String pageTitle = driver.getTitle();
		System.out.println(pageTitle);
		System.out.println(Thread.currentThread());
	}
	
	@Test
	public void linkedinTestCase() {
		driver.get("https://www.linkedin.com/");
		String pageTitle = driver.getTitle();
		System.out.println(pageTitle);
		System.out.println(Thread.currentThread());
	}
	
	@Test
	public void twitterTestCase() {
		driver.get("https://twitter.com/?lang=en");
		String pageTitle = driver.getTitle();
		System.out.println(pageTitle);
		System.out.println(Thread.currentThread());
	}

	@AfterTest
	public void AfterTestCaseRunning() {
		driver.close();
	}
}
