package pages;

import java.time.Duration;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.FluentWait;

public class BasePage {

	protected WebDriver driver;
	protected FluentWait<WebDriver> wait;
	private final int TIMEOUT = 10;
	private final int POLLING = 20;

	public BasePage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
		wait = new FluentWait<WebDriver>(driver).ignoring(NoSuchElementException.class, WebDriverException.class)
				.withTimeout(Duration.ofSeconds(TIMEOUT)).pollingEvery(Duration.ofMillis(POLLING));

	}
}
