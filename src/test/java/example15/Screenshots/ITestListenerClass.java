package example15.Screenshots;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class ITestListenerClass extends BaseClass implements ITestListener {

	@Override
	public void onTestFailure(ITestResult result) {
		captureScreenshot(result.getMethod().getMethodName() + ".jpg");
	}
}
