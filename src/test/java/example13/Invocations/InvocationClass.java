package example13.Invocations;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class InvocationClass {

	@Test(invocationCount = 5, invocationTimeOut = 99000, threadPoolSize = 2)
	public void invocationCounts() throws InterruptedException {
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://randomuser.me/");
		Thread.sleep(2000);
		String username = driver.findElement(By.xpath("//p[@id='user_value']")).getText();
		driver.findElement(By.xpath("//li[@data-label='email']")).click();
		String email = driver.findElement(By.xpath("//p[@id='user_value']")).getText();
		System.out.println(username + " | " + email);
		driver.close();
	}
}
