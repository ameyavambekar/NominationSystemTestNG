 	package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import util.ExcelUtil;

public class LoginPage extends BasePage {
	
	
		
	public LoginPage(WebDriver driver) 
	{
		super(driver);
	}

	@FindBy(id = "MainContent_lblmsg")
	private WebElement invalidCAPTCHAErrorMessage;
	
	@FindBy(tagName= "h3")
	private WebElement header;

	@FindBy(id = "MainContent_txtLoginId")
	private WebElement loginId;

	@FindBy(name = "ctl00$MainContent$txtPassword")
	private WebElement password;

	@FindBy(name = "ctl00$MainContent$txtCaptcha")
	private WebElement captchaTxtField;

	@FindBy(name = "MainContent_imgCaptcha")
	private WebElement captchaImage;
	
	@FindBy(name = "ctl00$MainContent$btnSubmit")
	private WebElement loginButton;
	
	@FindBy(name = "ctl00$MainContent$hdnCaptchaText")
	private WebElement captchaText;
	
	@FindBy(id = "MainContent_regexEmailValid")
	private WebElement invalidUsernameErrorMessage;
	
	@FindBy(id = "MainContent_lblmsg")
	private WebElement invalidCredentialsErrorMessage;
	
	public WebElement getInvalidUsernameErrorMessage() {
		wait.until(ExpectedConditions.visibilityOf(invalidUsernameErrorMessage));
		return invalidUsernameErrorMessage;
	}

	public void enterCaptchaAndLogin() {
		enterLoginId();
		enterPassword();
		enterCAPTCHA();
		loginButton.click();
	}

	public void enterLoginId() {
		String id = ExcelUtil.getRowValueFromHeader("Login ID");
		loginId.sendKeys(id);
	}

	public void enterInvalidLoginId() {
		loginId.sendKeys("!@$#");
		header.click();
	}
	
	
	public void enterPassword() {
		String pass = ExcelUtil.getRowValueFromHeader("Password");
		password.sendKeys(pass);
	}

	public void enterCAPTCHA() {
		String captcha = captchaText.getAttribute("value");
		captchaTxtField.sendKeys(captcha);
	}
	
	public void clickLoginButton() {
		loginButton.click();
	}
	
	public void enterInvalidPassword() {
		password.sendKeys("xyz");
	}	
	
	public WebElement getInvalidCredentialsErrorMessage() {
		return invalidCredentialsErrorMessage;
	}
	
	
}
