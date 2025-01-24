package util;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import factory.WebDriverManager;
import report.ExtentReportManager;

public class ReportUtil {
	
	/**
	 * Adds the screen shot.
	 *
	 * @param message the message
	 */
	public static void addScreenShot() {
		String base64Image = "data:image/png;base64,"
				+ ((TakesScreenshot) WebDriverManager.getDriver()).getScreenshotAs(OutputType.BASE64);
		ExtentReportManager.getCurrentTest().addScreenCaptureFromBase64String(base64Image);
	}

	/**
	 * Adds the screen shot.
	 *
	 * @param status  the status
	 * @param message the message
	 */
//	public static void addScreenShot(Status status, String message) {
//		String base64Image = "data:image/png;base64,"
//				+ ((TakesScreenshot) WebDriverManager.getDriver()).getScreenshotAs(OutputType.BASE64);
//		ExtentReportManager.getCurrentTest().log(status, message,
//				ExtentReportManager.getCurrentTest().addScreenCaptureFromBase64String(base64Image));
//	}

//	public static void logMessage(String message, String details) {
//		ExtentReportManager.getCurrentTest().log(LogStatus.INFO, message, details);
//	}
//
//	public static void logMessage(LogStatus status, String message, String details) {
//		ExtentReportManager.getCurrentTest().log(status, message, details);
//	}

}
