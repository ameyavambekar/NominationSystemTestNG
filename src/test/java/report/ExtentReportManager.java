package report;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import constants.Constants;

public class ExtentReportManager {

	/** The extent reports. */
	private static ExtentReports extentReports;
	private static ExtentSparkReporter spark;
	private static ExtentTest test;

	/** The map. */

	/**
	 * Gets the extent reports.
	 *
	 * @return the extent reports
	 */
	public static ExtentReports createExtentReports() {
		if (extentReports == null) {
			extentReports = new ExtentReports();
			spark = new ExtentSparkReporter(Constants.REPORT_DIRECTORY);
			extentReports.setSystemInfo("Host Name", "ITCELL-DEV50");
			extentReports.setSystemInfo("Environment", "Development");
			extentReports.setSystemInfo("User Name", "Ameya Ambekar");
			spark.config().setDocumentTitle("Nomination System");
			// Name of the report
			spark.config().setReportName("Tests");
			// Dark Theme
			spark.config().setTheme(Theme.DARK);
			extentReports.attachReporter(spark);
		}
		return extentReports;
	}

	public static ExtentReports getExtentReports() {
		return extentReports;
	}

	/**
	 * Start test.
	 *
	 * @param testName the test name
	 * @param desc     the desc
	 */
	public static void setTest(ExtentTest extentTest) {
		test = extentTest;
	}

	/**
	 * Gets the current test.
	 *
	 * @return the current test
	 */
	public static ExtentTest getCurrentTest() {
		return test;
	}

	/**
	 * End current test.
	 */
	public static void endCurrentTest() {
		getExtentReports().removeTest(test);
	}
}
