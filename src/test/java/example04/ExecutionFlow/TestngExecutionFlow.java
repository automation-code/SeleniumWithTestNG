package example04.ExecutionFlow;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestngExecutionFlow {

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("TESTING - BEFORE METHOD");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("TESTING - AFTER METHOD");
	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("TESTING - BEFORE CLASS");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("TESTING - AFTER CLASS");
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("TESTING - BEFORE TEST");
	}

	@AfterTest
	public void afterTest() {
		System.out.println("TESTING - AFTER TEST");
	}

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("TESTING - BEFORE SUITE");
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("TESTING - AFTER SUITE");
	}
	
	@Test
	public void testing() {
		System.out.println("TESTING - TESTING METHOD");
	}
}
