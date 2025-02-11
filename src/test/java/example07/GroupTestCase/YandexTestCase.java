package example07.GroupTestCase;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

public class YandexTestCase{

	@Test(groups = {"smoke", "sanity"})
	public void A() {
		System.out.println("YandexTestCase - Smoke + Sanity");
	}

	@Test(groups = {"smoke", "regression", "sanity"})
	public void B() {
		System.out.println("YandexTestCase - Smoke + Regression + Sanity");
	}

	@Test(groups = {"regression", "sanity"})
	public void C() {
		System.out.println("YandexTestCase - Regression + Sanity");
	}
}
