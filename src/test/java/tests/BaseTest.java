package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

import constants.Constants;
import factory.WebDriverManager;
import listeners.ReportListener;
import report.ExtentReportManager;
import util.LoggerUtil;
import util.TestProperties;

@Listeners(ReportListener.class)
public class BaseTest {

	/** The driver. */
	protected WebDriver driver;

	/**
	 * Global setup.
	 */
	@BeforeSuite(alwaysRun = true)
	public void globalSetup() {
		TestProperties.loadAllProperties();
	}

	/**
	 * Setup.
	 */
	@BeforeClass
	protected void setup() {
		System.setProperty("webdriver.chrome.driver", Constants.CHROME_DRIVER_PATH);
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("disable-infobars");
		driver = new ChromeDriver(ops);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(TestProperties.getProperty("base.url"));
		WebDriverManager.setDriver(driver);
	}

	@AfterClass
	public void tearDown() {
		ExtentReportManager.endCurrentTest();
		ExtentReportManager.getExtentReports().flush();
		driver.close();
		if (driver != null) {
			driver.quit();
		}
	}

	/**
	 * Wrap up.
	 */
	@AfterSuite
	public void wrapUp(ITestContext context) {
		int total = context.getAllTestMethods().length;
		int passed = context.getPassedTests().size();
		int failed = context.getFailedTests().size();
		int skipped = context.getSkippedTests().size();
		LoggerUtil.log("Total number of testcases : " + total);
		LoggerUtil.log("Number of testcases Passed : " + passed);
		LoggerUtil.log("Number of testcases Failed : " + failed);
		LoggerUtil.log("Number of testcases Skipped  : " + skipped);
		LoggerUtil.log("************************** Test Execution Finished ************************************");
	}

}
