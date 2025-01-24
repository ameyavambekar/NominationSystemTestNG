package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import util.LoggerUtil;

public class LogListener implements ITestListener {

	public String getTestName(ITestResult result) {
		return result.getName() != null ? result.getTestName() : result.getMethod().getConstructorOrMethod().getName();

	}

	public String getTestDescription(ITestResult result) {
		return result.getMethod().getDescription() != null ? result.getMethod().getDescription() : getTestName(result);
	}

	@Override
	public void onTestStart(ITestResult result) {
		LoggerUtil.log("Test: "+getTestName(result)+ " started." );
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		LoggerUtil.log(getTestName(result) + ": Test Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		Throwable t = result.getThrowable();
		String cause = "";
		if (t != null) {
			cause = t.getMessage();
		}
		LoggerUtil.log(getTestName(result) + ": Test Failed " + cause);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		LoggerUtil.log(getTestName(result) + ": Test Skipped");
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
	}

}
