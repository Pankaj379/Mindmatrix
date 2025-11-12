package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateSolutionCustomField extends BasePage {

	public CreateSolutionCustomField(WebDriver driver) { // From Base page.
		super(driver);
	}

	@FindBy(xpath = "//a[@class='btn btn-primary btn-block btn-effect1 btn-primary-cta ']")
	WebElement btnCreateRecord;

	@FindBy(xpath = "//input[@id='name']")
	WebElement txtNameField;

	@FindBy(xpath = "//textarea[@id='description']")
	WebElement txtDescription;

	public void clickCreate() {
		btnCreateRecord.click();
	}

	public void addName(String name) {
		txtNameField.sendKeys("Test34");
	}

	public void addDescription(String description) {
		txtDescription.sendKeys("Test description");
	}

}
