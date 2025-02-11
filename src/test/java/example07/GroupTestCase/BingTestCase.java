package example07.GroupTestCase;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

public class BingTestCase{

	@Test(groups = {"regression", "sanity"})
	public void A() {
		System.out.println("BingTestCase - Regression + Sanity");
	}

	@Test(groups = {"somke", "regression"})
	public void B() {
		System.out.println("BingTestCase - Smoke + Regression");
	}

	@Test(groups = {"regression", "sanity", "smoke"})
	public void C() {
		System.out.println("BingTestCase - Regression + Sanity + Smoke");
	}

}
