package tests;
import org.testng.Assert;
import org.testng.annotations.Test;

import components.Menu;
import factory.PageInstance;
import pages.EducationalQualificationsPage;
import pages.LoginPage;

public class TC_SUBJECT_INVALID extends BaseTest{
	
	@Test
	public void subjectInvalid() {
		LoginPage loginPage = PageInstance.getInstance(LoginPage.class);
		loginPage.enterCaptchaAndLogin();
		Menu menu = PageInstance.getInstance(Menu.class);
		menu.navigateToEducationalQualifications();
		EducationalQualificationsPage educationalQualificationsPage = PageInstance.getInstance(EducationalQualificationsPage.class);
		educationalQualificationsPage.getSubject().sendKeys("!@$#!@$#12341243");
		Assert.assertTrue(educationalQualificationsPage.getSubject().getText().isEmpty());
	}

}
