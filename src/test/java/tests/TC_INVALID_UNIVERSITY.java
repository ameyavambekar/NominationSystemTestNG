package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import components.Menu;
import factory.PageInstance;
import pages.EducationalQualificationsPage;
import pages.LoginPage;

public class TC_INVALID_UNIVERSITY extends BaseTest {
	
	@Test
	public void invalidUniversity() {
		LoginPage loginPage = PageInstance.getInstance(LoginPage.class);
		loginPage.enterCaptchaAndLogin();
		Menu menu = PageInstance.getInstance(Menu.class);
		menu.navigateToEducationalQualifications();
		EducationalQualificationsPage educationalQualificationsPage = PageInstance.getInstance(EducationalQualificationsPage.class);
		educationalQualificationsPage.getUniversity().sendKeys("!@#$!@$#");
		Assert.assertTrue(educationalQualificationsPage.getUniversity().getText().isEmpty());
	}
	

}
