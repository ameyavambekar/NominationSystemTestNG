package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import components.Menu;
import factory.PageInstance;
import pages.EducationalQualificationsPage;
import pages.LoginPage;


public class TC_YEAR_INVALID extends BaseTest{
	
	
	@Test
	public void invalidYear() {
		LoginPage loginPage = PageInstance.getInstance(LoginPage.class);
		loginPage.enterCaptchaAndLogin();
		Menu menu = PageInstance.getInstance(Menu.class);
		menu.navigateToEducationalQualifications();
		EducationalQualificationsPage educationalQualificationsPage = PageInstance.getInstance(EducationalQualificationsPage.class);
		educationalQualificationsPage.getYear().sendKeys("XCV!@#,.[]{}");
		Assert.assertTrue(educationalQualificationsPage.getYear().getText().isEmpty());
	}

}
