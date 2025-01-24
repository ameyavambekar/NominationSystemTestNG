package pages;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import util.ExcelUtil;

public class ProfilePage extends BasePage {

	public ProfilePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "MainContent_ddlNominationTypeEng")
	private WebElement nominationTypeSelectDropDown;

	@FindBy(id = "MainContent_txtUnivDeptEng")
	private WebElement department;

	@FindBy(id = "MainContent_txtDOBEng")
	private WebElement dateOfBirth;

	@FindBy(id = "MainContent_txtPostalAddressEng")
	private WebElement postalAddress;

	@FindBy(id = "MainContent_txtPermanentAddressEng")
	private WebElement permanentAddress;

	@FindBy(id = "MainContent_ChkBoxIsAddressSame")
	private WebElement sameAddress;

	@FindBy(id = "MainContent_btnSubmit")
	private WebElement submitButton;

	@FindBy(id = "MainContent_btnCancle")
	private WebElement cancelButton;

	public WebElement getNominationTypeDropDown() {
		return nominationTypeSelectDropDown;
	}

	public WebElement getDateOfBirth() {
		return dateOfBirth;
	}

	public WebElement getPostalAddress() {
		return postalAddress;
	}

	public WebElement getPermanentAddress() {
		return driver.findElement(By.id("MainContent_txtPermanentAddressEng"));
	}

	public WebElement getDepartment() {
			department = driver.findElement(By.id("MainContent_txtUnivDeptEng"));
			return department;
	}

	public void enterDepartment() {
		String dept = ExcelUtil.getRowValueFromHeader("Department");
		try {
			department.sendKeys(dept);
		} catch (WebDriverException exp) {
			department = driver.findElement(By.id("MainContent_txtUnivDeptEng"));
			department.sendKeys(dept);
		}
	}

	public void enterDateOfBirth() {
		String dob1 = ExcelUtil.getRowValueFromHeader("Date of Birth");
		SimpleDateFormat sdf1 = new SimpleDateFormat("E MMM dd HH:mm:ss z yyyy");
		SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
		Date date = null;
		String dob2 = null;
		try {
			date = sdf1.parse(dob1);
			dob2 = sdf2.format(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		
		try {
			dateOfBirth.sendKeys(dob2);
		} catch (StaleElementReferenceException stale) {
			dateOfBirth = driver.findElement(By.id("MainContent_txtDOBEng"));
			dateOfBirth.sendKeys(dob2);
		} catch(UnhandledAlertException alert) {
			driver.switchTo().alert().accept();
		} catch(WebDriverException wde) {
			driver.switchTo().defaultContent();
			dateOfBirth = driver.findElement(By.id("MainContent_txtDOBEng"));
			dateOfBirth.sendKeys(dob2);
		}

	}

	public void enterPostalAddress() {
		String address = ExcelUtil.getRowValueFromHeader("Postal Address");
		try {
			postalAddress.sendKeys(address);
		} catch (StaleElementReferenceException stale) {
			postalAddress = driver.findElement(By.id("MainContent_txtPostalAddressEng"));
			postalAddress.sendKeys(address);
		}
	}

	public void enterPermanentAddress() {
		String address = ExcelUtil.getRowValueFromHeader("Permanent Address");
		try {
			wait.until(ExpectedConditions.elementToBeClickable(permanentAddress));
			permanentAddress.sendKeys(address);
		} catch (StaleElementReferenceException stale) {
			permanentAddress = driver.findElement(By.id("MainContent_txtPermanentAddressEng"));
			permanentAddress.sendKeys(address);
		}
	}

	public void selectNominationType() {
		String type = ExcelUtil.getRowValueFromHeader("Nomination Type");
		Select nominationType = new Select(nominationTypeSelectDropDown);
		nominationType.selectByVisibleText(type);
	}

	public void postalAddressSameAsPermanentAddress() {
		sameAddress.click();
	}

	public void clickSubmitButton() {
//		JavascriptExecutor executor = (JavascriptExecutor) driver;
//		executor.executeScript("arguments[0].click();", submitButton);
		submitButton.sendKeys(Keys.ENTER);
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

	public void clickCancelButton() {
		cancelButton.sendKeys(Keys.ENTER);

	}
}
