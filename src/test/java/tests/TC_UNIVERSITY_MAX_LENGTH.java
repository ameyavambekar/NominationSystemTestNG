package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import components.Menu;
import factory.PageInstance;
import pages.EducationalQualificationsPage;
import pages.LoginPage;
import util.TestUtil;

public class TC_UNIVERSITY_MAX_LENGTH extends BaseTest {

	@Test
	public void universityMaxLength() {
		LoginPage loginPage = PageInstance.getInstance(LoginPage.class);
		loginPage.enterCaptchaAndLogin();
		Menu menu = PageInstance.getInstance(Menu.class);
		menu.navigateToEducationalQualifications();
		EducationalQualificationsPage educationalQualificationsPage = PageInstance
				.getInstance(EducationalQualificationsPage.class);
		educationalQualificationsPage.getUniversity().sendKeys(TestUtil.generateRandomString(201));
		Assert.assertTrue(educationalQualificationsPage.getUniversity().getAttribute("value").length() == 200);

	}

}
