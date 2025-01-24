package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class EducationalQualificationsPage extends BasePage {

	WebDriver driver;

	public EducationalQualificationsPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	@FindBy(id = "MainContent_ddlExam")
	WebElement examination;

	@FindBy(id = "MainContent_txtCourse")
	WebElement course;

	@FindBy(id = "MainContent_txtUniBoard")
	WebElement university;

	@FindBy(id = "MainContent_ddlMnthPass")
	WebElement month;

	@FindBy(id = "MainContent_txtPassYr")
	WebElement year;

	@FindBy(id = "MainContent_txtSub")
	WebElement subject;

	@FindBy(id = "MainContent_txtObtained")
	WebElement marks;

	@FindBy(id = "MainContent_txtOutOf")
	WebElement outOf;

	@FindBy(id = "MainContent_txtPercentage")
	WebElement percentage;

	@FindBy(id = "MainContent_txtDiv")
	WebElement division;

	@FindBy(id = "MainContent_btnSave")
	WebElement save;

	@FindBy(id = "MainContent_btnCancle")
	WebElement cancel;

	@FindBy(xpath = "//label[text()='Examination']//preceding-sibling::span[text()='*']")
	WebElement examinationMandatory;

	@FindBy(xpath = "//label[text()=' Course Name']//preceding-sibling::span[text()='*']")
	WebElement courseMandatory;

	@FindBy(xpath = "//label[text()='University/Board']//preceding-sibling::span[text()='*']")
	WebElement universityMandatory;

	@FindBy(xpath = "//label[text()='Month & Year of Passing']//preceding-sibling::span[text()='*']")
	WebElement monthMandatory;

	@FindBy(xpath = "//label[text()='Month & Year of Passing']//preceding-sibling::span[text()='*']")
	WebElement yearMandatory;

	@FindBy(xpath = "//label[text()='Subjects Spl./Gen.']//preceding-sibling::span[text()='*']")
	WebElement subjectMandatory;

	@FindBy(xpath = "//label[text()='Marks Obtained']//preceding-sibling::span[text()='*']")
	WebElement marksMandatory;

	@FindBy(xpath = "//label[text()='Out of']//preceding-sibling::span[text()='*']")
	WebElement outOfMandatory;

	@FindBy(xpath = "//label[text()='Class/Div./Grade awarded']//preceding-sibling::span[text()='*']")
	WebElement divisionMandatory;
	

	public WebElement getExaminationDropdown() {
		return examination;
	}

	public WebElement getCourse() {
		return course;
	}

	public WebElement getUniversity() {
		return university;
	}

	public WebElement getMonthDropdown() {
		return month;
	}

	public WebElement getYear() {
		return year;
	}

	public WebElement getSubject() {
		return subject;
	}

	public WebElement getMarks() {
		return marks;
	}

	public WebElement getOutOf() {
		return outOf;
	}

	public WebElement getPercentage() {
		return percentage;
	}

	public WebElement getDivision() {
		return division;
	}

	public WebElement getSaveButton() {
		return save;
	}

	public WebElement getCancelButton() {
		return cancel;
	}
	
	public WebElement getExaminationMandatory() {
		return examinationMandatory;
	}

	public WebElement getCourseMandatory() {
		return courseMandatory;
	}

	public WebElement getUniversityMandatory() {
		return universityMandatory;
	}

	public WebElement getMonthMandatory() {
		return monthMandatory;
	}

	public WebElement getYearMandatory() {
		return yearMandatory;
	}

	public WebElement getSubjectMandatory() {
		return subjectMandatory;
	}

	public WebElement getMarksMandatory() {
		return marksMandatory;
	}

	public WebElement getOutOfMandatory() {
		return outOfMandatory;
	}

	public WebElement getDivisionMandatory() {
		return divisionMandatory;
	}

	public void clickSaveButton() {
		save.click();
	}

	public void clickCancelButton() {
		cancel.click();
	}

	public void selectExamination(String option) {
		Select exam = new Select(examination);
		exam.selectByVisibleText(option);
	}

	public void selectMonth(String option) {
		Select monthSelect = new Select(month);
		monthSelect.selectByVisibleText(option);
	}

	
}
