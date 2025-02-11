package example07.GroupTestCase;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

public class GoogleTestCase {
	
	@Test(groups = {"somke", "regression", "sanity"})
	public void A() {
		System.out.println("GoogleTestCase - Smoke + Regression + Sanity");
	}

	@Test(groups = {"somke", "sanity"})
	public void B() {
		System.out.println("GoogleTestCase - Smoke + Sanity");
	}

	@Test(groups = {"regression", "sanity"})
	public void C() {
		System.out.println("GoogleTestCase - Regression + Sanity");
	}
}
