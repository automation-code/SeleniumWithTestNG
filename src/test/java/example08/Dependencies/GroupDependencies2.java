package example08.Dependencies;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

public class GroupDependencies2 {

	@Test(groups = "smoke")
	public void testCase1() {
		System.out.println("testCase1 - Smoke");
	}

	@Test(groups = "sanity")
	public void testCase2() {
		System.out.println("testCase2 - Sanity");
	}

	@Test(groups = "sanity")
	public void testCase3() {
		System.out.println("testCase3 - Sanity");
	}

	@Test(groups = "smoke")
	public void testCase4() {
		System.out.println("testCase4 - Smoke");
	}

	@Test(groups = "regression")
	public void testCase5() {
		System.out.println("testCase5 - Regression");
	}

	@Test(groups = "regression")
	public void testCase6() {
		System.out.println("testCase6 - Regression");
	}
}
