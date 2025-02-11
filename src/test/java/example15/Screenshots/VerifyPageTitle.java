package example15.Screenshots;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifyPageTitle extends BaseClass{
	
	@Test
	public void verifyGooglePageTitle() {
		driver.get("https://www.google.com");
		String actualTitle = driver.getTitle();
		String expectedTitle = "Google";
		Assert.assertEquals(actualTitle, expectedTitle);
	}
	
	@Test
	public void verifyBingPageTitle() {
		driver.get("https://www.bing.com");
		String actualTitle = driver.getTitle();
		String expectedTitle = "Bing";
		Assert.assertEquals(actualTitle, expectedTitle);
	}
	
	@Test
	public void verifyYandexPageTitle() {
		driver.get("https://yandex.com");
		String actualTitle = driver.getTitle();
		String expectedTitle = "Yandex — a fast Internet search";
		Assert.assertEquals(actualTitle, expectedTitle);
	}
	
	@Test
	public void verifyFacebookPageTitle() {
		driver.get("https://www.facebook.com");
		String actualTitle = driver.getTitle();
		String expectedTitle = "Facebook – log in or sign up - capture";
		Assert.assertEquals(actualTitle, expectedTitle);
	}
	
	@Test
	public void verifyTwitterPageTitle() {
		driver.get("https://twitter.com");
		String actualTitle = driver.getTitle();
		String expectedTitle = "X. It’s what’s happening / X - capture";
		Assert.assertEquals(actualTitle, expectedTitle);
	}
	
}
