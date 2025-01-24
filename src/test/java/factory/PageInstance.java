package factory;

import org.openqa.selenium.WebDriver;

import pages.BasePage;

public class PageInstance {

	public static <T extends BasePage> T getInstance(Class<T> type) {

		try {
			return type.getConstructor(WebDriver.class).newInstance(WebDriverManager.getDriver());
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

}
