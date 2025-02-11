package example16.ExtentReports;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportUtils implements ITestListener {

	public static ExtentSparkReporter sReporter;
	public static ExtentReports eReport;
	public static ExtentTest eTest;
	public static String htmlFile = System.getProperty("user.dir") + "/src/test/java/example16/ExtentReports/eReports.html";
	

	public void onStart(ITestContext context) {
		sReporter = new ExtentSparkReporter(htmlFile);

		sReporter.config().setDocumentTitle("Automation Report");
		sReporter.config().setReportName("Functional Testing");
		sReporter.config().setTheme(Theme.DARK);
		sReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");

		eReport = new ExtentReports();
		eReport.attachReporter(sReporter);

		eReport.setSystemInfo("Name", "Automation");
		eReport.setSystemInfo("Machine", "Windows-PC");
		eReport.setSystemInfo("OS", "Windows 11");
		eReport.setSystemInfo("User", "Google");
		eReport.setSystemInfo("Browser", "Chrome");
	}

	public void onTestSuccess(ITestResult result) {
		if (result.getStatus() == ITestResult.SUCCESS) {
			eTest = eReport.createTest(result.getName());
			eTest.log(Status.PASS, MarkupHelper.createLabel(result.getName() + " - PASS", ExtentColor.GREEN));
		}
		
	}

	public void onTestFailure(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			eTest = eReport.createTest(result.getName());
			eTest.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " - FAIL", ExtentColor.RED));
			eTest.log(Status.FAIL, result.getThrowable());
		}
		
	}

	public void onTestSkipped(ITestResult result) {
		if (result.getStatus() == ITestResult.SKIP) {
			eTest = eReport.createTest(result.getName());
			eTest.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " - SKIPPED", ExtentColor.GREY));
		}
		
	}

	public void onFinish(ITestContext context) {
		eReport.flush();
	}
}
