package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import components.Menu;
import factory.PageInstance;
import pages.EducationalQualificationsPage;
import pages.LoginPage;

public class TC_MARKS_NEGATIVE extends BaseTest{
	
	@Test
	public void TC_MARKS_NEGATIVE() {
		LoginPage loginPage = PageInstance.getInstance(LoginPage.class);
		loginPage.enterCaptchaAndLogin();
		Menu menu = PageInstance.getInstance(Menu.class);
		menu.navigateToEducationalQualifications();
		EducationalQualificationsPage educationalQualificationsPage = PageInstance.getInstance(EducationalQualificationsPage.class);
		educationalQualificationsPage.getMarks().sendKeys("-91");
		Assert.assertFalse(educationalQualificationsPage.getMarks().getAttribute("value").contains("-"));
	}

}
