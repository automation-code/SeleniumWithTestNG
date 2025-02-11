package example06.EnableDisable;

import org.testng.annotations.Test;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class EnableDisableTestCase {

	WebDriver driver;

	@Parameters("browserName")
	@BeforeTest
	public void openBrowser(String browserName) {
		switch (browserName.toLowerCase()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case "safari":
			WebDriverManager.safaridriver().setup();
			driver = new SafariDriver();
			break;
		default:
			System.out.println("Browser is invalid");
			break;
		}
		driver.manage().window().maximize();
	}

	@Parameters("baseUrl")
	@Test
	public void openUrl(String baseUrl) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get(baseUrl);
	}

	@Parameters({ "username", "password" })
	@Test
	public void loginUser(String username, String password) {
		driver.findElement(By.xpath("//*[@id='username']")).sendKeys(username);
		driver.findElement(By.xpath("//*[@id='password']")).sendKeys(password);
		driver.findElement(By.xpath("//*[@id='submit']")).click();
	}

	@Test
	public void veriftyPageTitle() {
		System.out.println(driver.getTitle());
	}

	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}

}
