package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPage extends BasePage{

	public DashboardPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(css = "h3")
	private WebElement header;
		
	
	
	public WebElement getHeader() {
		return header;
		
	}

}
