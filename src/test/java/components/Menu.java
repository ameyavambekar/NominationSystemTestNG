package components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pages.BasePage;

public class Menu extends BasePage {

	public Menu(WebDriver driver) {
		super(driver);
	}

	@FindBy(css = ".sidebar-menu")
	private WebElement menu;

	@FindBy(xpath = "//span[text()='User Manual']")
	private WebElement userManualLink;

	@FindBy(xpath = "//span[text()='Dashboard']")
	private WebElement dashboardLink;

	@FindBy(xpath = "//span[text()='Profile']")
	private WebElement profileLink;

	@FindBy(xpath = "//span[text()='Educational Qualifications']")
	private WebElement educationalQualificationsLink;
	
	@FindBy(xpath = "//span[text()='Teaching Experience']")
	private WebElement teachingExperienceLink;

	@FindBy(xpath = "//span[text()='Upload Photo/Signature']")
	private WebElement uploadLink;

	@FindBy(xpath = "//span[text()='Apply for Nomination']")
	private WebElement applyForNominationLink;

	public WebElement getMenu() {
		return menu;
	}

	public WebElement getUserManualLink() {
		return userManualLink;
	}

	public WebElement getDashboardLink() {
		return dashboardLink;
	}

	public WebElement getProfileLink() {
		return profileLink;
	}

	public WebElement getEducationalQualificationsLink() {
		return educationalQualificationsLink;
	}

	public WebElement getTeachingExperienceLink() {
		return teachingExperienceLink;
	}

	public WebElement getUploadLink() {
		return uploadLink;
	}

	public WebElement getApplyForNominationLink() {
		return applyForNominationLink;
	}

	
	public void navigateToDashboard() {
		dashboardLink.click();
	}
	
	public void navigateToProfile() {
		profileLink.click();
	}
	
	public void navigateToEducationalQualifications() {
		educationalQualificationsLink.click();
	}
	
	public void navigateToTeachingExperience() {
		teachingExperienceLink.click();
	}
	
	public void navigateToUploadPhotoSignature() {
		uploadLink.click();
	}
	
	public void navigateToApplyNomination() {
		applyForNominationLink.click();
	}

}
