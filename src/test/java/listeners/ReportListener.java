package listeners;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import factory.WebDriverManager;
import report.ExtentReportManager;

public class ReportListener implements ITestListener {

	private ExtentTest test;

	public String getTestName(ITestResult result) {
		return result.getMethod().getMethodName();

	}

	public String getTestDescription(ITestResult result) {
		return result.getMethod().getDescription();
	}

	@Override
	public void onTestStart(ITestResult result) {
		test = ExtentReportManager.createExtentReports().createTest(getTestName(result), getTestDescription(result));
		ExtentReportManager.setTest(test);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, result.getMethod().getMethodName());

	}

	@Override
	public void onTestFailure(ITestResult result) {
		Throwable t = result.getThrowable();
		String cause = "";
		if (t != null) {
			cause = t.getMessage();
			test.log(Status.FAIL, "Test: " + result.getMethod().getMethodName() + " failed because: " + cause);
			String base64Image = "data:image/png;base64,"
					+ ((TakesScreenshot) WebDriverManager.getDriver()).getScreenshotAs(OutputType.BASE64);
			test.addScreenCaptureFromBase64String(base64Image, "Screenshot");
		}

	}

	@Override
	public void onTestSkipped(ITestResult result) {

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	@Override
	public void onStart(ITestContext context) {

	}

	@Override
	public void onFinish(ITestContext context) {
	}

}
