package example09.DataProvider;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTesting {

	public static WebDriver driver;
	public static String xlfile = System.getProperty("user.dir") + "/src/test/resources/xlData/testData.xlsx";
	ExcelUtils xlutils = new ExcelUtils();

	@Test(dataProvider = "loginUsers")
	public void loginPage(String username, String password) throws Exception {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://practicetestautomation.com/practice-test-login/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
		driver.findElement(By.xpath("//button[@id='submit']")).click();
		int rows = xlutils.getRowCount(xlfile, "LoginUsers");
		for (int i = 1; i <= rows; i++) {
			if (driver.getCurrentUrl().equals("https://practicetestautomation.com/logged-in-successfully/")) {
				Assert.assertTrue(true);
				xlutils.setCellData(xlfile, "LoginUsers", i, 2, "PASSED");
				xlutils.fillGreenColor(xlfile, "LoginUsers", i, 2);
			} else if (driver.getTitle().equals("Test Login | Practice Test Automation")) {
				Assert.assertTrue(false);
				xlutils.setCellData(xlfile, "LoginUsers", i, 2, "FAILED");
				xlutils.fillRedColor(xlfile, "LoginUsers", i, 2);
			}
		}
	}

	@DataProvider(name = "loginUsers")
	public String[][] getData() throws Exception {

		int rows = xlutils.getRowCount(xlfile, "LoginUsers");
		int cols = xlutils.getCellCount(xlfile, "LoginUsers", 1);

		String loginData[][] = new String[rows][cols];
		for (int i = 1; i <= rows; i++) {
			for (int j = 0; j < cols; j++) {
				loginData[i - 1][j] = xlutils.getCellData(xlfile, "LoginUsers", i, j);
			}
		}
		return loginData;
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}
