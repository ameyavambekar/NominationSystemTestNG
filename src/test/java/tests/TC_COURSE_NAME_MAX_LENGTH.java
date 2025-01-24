package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import components.Menu;
import factory.PageInstance;
import pages.EducationalQualificationsPage;
import pages.LoginPage;
import util.TestUtil;

public class TC_COURSE_NAME_MAX_LENGTH extends BaseTest{
	
	@Test
	public void courseNameMaxLength() {
		LoginPage loginPage = PageInstance.getInstance(LoginPage.class);
		loginPage.enterCaptchaAndLogin();
		Menu menu = PageInstance.getInstance(Menu.class);
		menu.navigateToEducationalQualifications();
		EducationalQualificationsPage educationalQualificationsPage = PageInstance.getInstance(EducationalQualificationsPage.class);
		educationalQualificationsPage.getCourse().sendKeys(TestUtil.generateRandomString(100));
		Assert.assertTrue(educationalQualificationsPage.getCourse().getAttribute("value").length()==50);
	}

}
