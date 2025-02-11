package example11.ExpectedExceptions;

import org.testng.annotations.Test;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ExpectedExceptions {
	// If exception is not happen then it will throws the exception
	
	@Test(expectedExceptions = {NoSuchElementException.class})
	public void timeOutConditions() {
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.quit();
	}

}
