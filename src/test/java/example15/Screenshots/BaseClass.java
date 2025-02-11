package example15.Screenshots;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;
	public static String screenshotSubDir;

	@BeforeTest
	public void openBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@AfterMethod
	public void screenshotCapture(ITestResult result) {
		if(result.getStatus() == ITestResult.FAILURE) {
			captureScreenshot(result.getMethod().getMethodName() + ".jpg");
		}
	}
	
	public void captureScreenshot(String fileName) {
		if (screenshotSubDir == null) {
			LocalDateTime dateTime = LocalDateTime.now();
			DateTimeFormatter dtFormatter = DateTimeFormatter.ofPattern("ddMMyyyy-HHmmss");
			screenshotSubDir = dateTime.format(dtFormatter);
		}
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		File destFile = new File("./Screenshots/" + screenshotSubDir + "/" + fileName);
		try {
			FileUtils.copyFile(sourceFile, destFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Screenshot saved successfully");
	}

	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}
}
