package tests;
import org.testng.Assert;
import org.testng.annotations.Test;

import components.Menu;
import factory.PageInstance;
import pages.EducationalQualificationsPage;
import pages.LoginPage;

public class TC_COURSE_NAME_INVALID extends BaseTest {
	
	@Test
	public void invalidCourseName() {
		LoginPage loginPage = PageInstance.getInstance(LoginPage.class);
		loginPage.enterCaptchaAndLogin();
		Menu menu = PageInstance.getInstance(Menu.class);
		menu.navigateToEducationalQualifications();
		EducationalQualificationsPage educationalQualificationsPage = PageInstance.getInstance(EducationalQualificationsPage.class);
		educationalQualificationsPage.getCourse().sendKeys("!@$#!@$#");
		Assert.assertTrue(educationalQualificationsPage.getCourse().getText().isEmpty());
	}
	

}
