package Com.Banking.Utilities;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import Com.Banking.BaseClass.Banking_BaseClass;

public class Listeners extends Banking_BaseClass implements ITestListener {

	ExtentReports extent = ExtentReporterNG.getReportObject();

	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();

	public void onTestStart(ITestResult result) {
		// Extent Report
		ExtentTest test = extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test);
	}

	public void onTestSuccess(ITestResult result) {
		// Extent Report
		extentTest.get().log(Status.PASS, "Test Passed");
	}

	public void onTestFailure(ITestResult result) {
		// Screenshot
		ExtentTest test = extentTest.get();
		if (test != null) {
			test.fail(result.getThrowable());
			String testMethodName = result.getMethod().getMethodName();
			WebDriver driver = getDriverInstance(); // Get driver instance from the base class
			try {
				test.addScreenCaptureFromPath(getScreenShot(testMethodName), result.getMethod().getMethodName());
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			// Handle the case where extentTest is null
			System.out.println("ExtentTest object is null. Cannot log test failure.");
		}
	}

	public WebDriver getDriverInstance() {
		return driver; // Return the driver instance from the base class
	}

	public void onTestSkipped(ITestResult result) {
		ExtentTest test = extentTest.get();
		if (test != null) {
			test.log(Status.SKIP, "Test Skipped");
		}
	}

	public void onStart(ITestContext context) {
		ExtentTest test = extent.createTest(context.getName());
		extentTest.set(test);
		test.log(Status.INFO, "Test Started");
	}

	public void onFinish(ITestContext context) {
		ExtentTest test = extentTest.get();
		if (test != null) {
			test.log(Status.INFO, "Test Finish");
		}
		extent.flush();
	}
}
