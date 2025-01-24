package factory;

import org.openqa.selenium.WebDriver;

public class WebDriverManager {

	private static WebDriver driver;

	public static WebDriver getDriver() {
		if (driver == null) {
			throw new IllegalStateException(
					"WebDriver has not been set, Please set WebDriver instance by WebDriverManager set method");
		} else {
			return driver;
		}
	}

	public static void setDriver(WebDriver driverInstance) {
		driver = driverInstance;
	}

	public static void closeDriver() {
		if (driver != null) {
			driver.close();
			driver.quit();
		}

	}

}
