package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import components.Menu;
import factory.PageInstance;
import pages.EducationalQualificationsPage;
import pages.LoginPage;
import util.TestUtil;

public class TC_SUBJECT_MAX_LENGTH extends BaseTest {

	@Test
	public void subjectMaxLength() {
		LoginPage loginPage = PageInstance.getInstance(LoginPage.class);
		loginPage.enterCaptchaAndLogin();
		Menu menu = PageInstance.getInstance(Menu.class);
		menu.navigateToEducationalQualifications();
		EducationalQualificationsPage educationalQualificationsPage = PageInstance
				.getInstance(EducationalQualificationsPage.class);
		educationalQualificationsPage.getSubject().sendKeys(TestUtil.generateRandomString(201));
		Assert.assertTrue(educationalQualificationsPage.getSubject().getAttribute("value").length() == 200);
	}

}
