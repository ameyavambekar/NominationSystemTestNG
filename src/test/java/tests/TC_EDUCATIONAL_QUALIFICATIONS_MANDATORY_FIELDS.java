package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import components.Menu;
import factory.PageInstance;
import factory.WebDriverManager;
import pages.EducationalQualificationsPage;
import pages.LoginPage;

public class TC_EDUCATIONAL_QUALIFICATIONS_MANDATORY_FIELDS extends BaseTest {
	
	@Test
	public void mandatoryFieldsTest() {
		LoginPage loginPage = PageInstance.getInstance(LoginPage.class);
		loginPage.enterCaptchaAndLogin();
		Menu menu = new Menu(WebDriverManager.getDriver());
		menu.navigateToEducationalQualifications();
		EducationalQualificationsPage educationalQualificationsPage = PageInstance.getInstance(EducationalQualificationsPage.class);
		educationalQualificationsPage.clickSaveButton();
		Assert.assertTrue(educationalQualificationsPage.getExaminationMandatory().isDisplayed());
		Assert.assertTrue(educationalQualificationsPage.getCourseMandatory().isDisplayed());
		Assert.assertTrue(educationalQualificationsPage.getUniversityMandatory().isDisplayed());
		Assert.assertTrue(educationalQualificationsPage.getMonthMandatory().isDisplayed());
		Assert.assertTrue(educationalQualificationsPage.getYearMandatory().isDisplayed());
		Assert.assertTrue(educationalQualificationsPage.getSubjectMandatory().isDisplayed());
		Assert.assertTrue(educationalQualificationsPage.getMarksMandatory().isDisplayed());
		Assert.assertTrue(educationalQualificationsPage.getOutOfMandatory().isDisplayed());
		Assert.assertTrue(educationalQualificationsPage.getDivisionMandatory().isDisplayed());
	}

}
