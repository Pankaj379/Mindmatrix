package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateSolutionCustomField extends BasePage {

	public CreateSolutionCustomField(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//h1[normalize-space()='Solution Custom Fields']")
	WebElement page_Validity_CreateRecord;

	@FindBy(xpath = "//a[@class='btn btn-primary btn-block btn-effect1 btn-primary-cta ']")
	WebElement btnCreateRecord;

	@FindBy(xpath = "//input[@id='name']")
	WebElement txtNameField;

	@FindBy(xpath = "//textarea[@id='description']")
	WebElement txtDescription;

	/*
	 * @FindBy(xpath = "//ul[@class='select2-choices']") WebElement txtDropDown;
	 * 
	 * @FindBy(xpath = "//div[@id='select2-drop']//ul//li//div") List<WebElement>
	 * filterDropOptions;
	 */




	@FindBy(xpath = "//i[@class='btn-icon fa fa-angle-double-right']")
	WebElement btnNext;

	@FindBy(xpath = "//i[@title='Click here to edit']")
	WebElement btnEditFolder;

	@FindBy(xpath = "//input[@id='name']")
	WebElement txtEditFolderName;

	@FindBy(xpath = "//input[@id='english']")
	WebElement txtLocalEnglishName;

	@FindBy(xpath = "//div[@class='modal-header']//div[@id='_save']//a[@class='btn btn-default']")
	WebElement btnSaveFolder;

	@FindBy(xpath = "//a[normalize-space()='-- Add Another Form Field --']")
	WebElement btnAddCustomField;

	@FindBy(xpath = "//div[@id='s2id_fieldtype']//span[contains(@class,'select2-chosen')]")
	WebElement dropdownSelectField;
	@FindBy(xpath = "//ul[@class='select2-results']//li//div")
	List<WebElement> fieldTypeOptions;

	@FindBy(xpath = "//input[@id='displayname']")
	WebElement txtFieldDisplayName;

	@FindBy(xpath = "//input[@id='parsername']")
	WebElement txtFieldParseName;

	@FindBy(xpath = "//input[@id='charmin']")
	WebElement txtMinCharLimit;

	@FindBy(xpath = "//input[@id='charmax']")
	WebElement txtMaxCharLimit;

	@FindBy(xpath = "//label[normalize-space()='Required Field']")
	WebElement checkBoxRequired;

	@FindBy(xpath = "//label[normalize-space()='Show Tooltip']")
	WebElement checkShowTooltip;

	@FindBy(xpath = "//label[normalize-space()='Info Icon']")
	WebElement checkInfoIcon;

	@FindBy(xpath = "//input[@id='tooltiptext']")
	WebElement txtTooltipMsg;

	@FindBy(xpath = "//div[@class='modal-header']//div[@id='_savedata']//a[@class='btn btn-default']")
	WebElement btnSave;
	
	@FindBy(xpath = "//i[contains(@class,'btn-icon fa fa-angle-double-right')]")
	WebElement btnClickNext;
	
	@FindBy(xpath = "//div[@id='MsgBoxBack']//button[@id='bot2-Msg2-1']")
	WebElement btnOkay;
	
	@FindBy(xpath = "//div[contains(text(),'Finish')]")
	WebElement btnFinish;
	
	
	
	
	
	
	










// ---------------------------Methods------------------------------------------

	public String page_Valid_CreateRecord() { 

		try {
			return (page_Validity_CreateRecord.getText()); // only getting text from here.
		} catch (Exception e) {
			return (e.getMessage()); // if there is no text then exception message will display.
		}
	}

	public void clickCreate() {
		btnCreateRecord.click();
	}

	public void setName(String name) {
		txtNameField.sendKeys(name);
	}

	public void setDescription(String description) {
		txtDescription.sendKeys(description);
	}

	/*
	 * public void selectFilterOption(String dropdownName) { txtDropDown.click();
	 * txtDropDown.sendKeys(dropdownName);
	 * 
	 * for(int i=0 ; i<filterDropOptions.size() ; i++) {
	 * System.out.println(filterDropOptions.get(i).getText());
	 * 
	 * if(filterDropOptions.get(i).getText().equals(dropdownName)) {
	 * filterDropOptions.get(i).click(); break; } } }
	 */

	public void clickNext() {
		btnNext.click();
	}

	public void clickEditCustomFolder() {
		btnEditFolder.click();
	}

	public void setFolderName(String folderName) {
		txtEditFolderName.sendKeys(folderName);
	}

	public void setLocalFolderName(String localFolderName) {
		txtLocalEnglishName.sendKeys("Localized Solution folder");
	}

	public void clickSave() {
		btnSaveFolder.click();
	}

	public void clickEditCustomField() {
		btnAddCustomField.click();
	}

	public void selectFieldType(String fieldName) {
		dropdownSelectField.click();   // open Select2 list

		for (WebElement option : fieldTypeOptions) {
			if (option.getText().equalsIgnoreCase(fieldName)) {
				option.click();
				break;
			}
		}
	}

	public void setFieldDisplayName(String displayName) {
		txtFieldDisplayName.sendKeys(displayName);
	}

	public void setFieldParseName(String parseName) {
		txtFieldParseName.sendKeys(parseName);
	}

	public void setMinCharLimit(String minCharLimit) {
		txtMinCharLimit.sendKeys(minCharLimit);
	}

	public void setMaxCharLimit(String maxCharLimit) {
		txtMaxCharLimit.clear();
		txtMaxCharLimit.sendKeys(maxCharLimit);
	}

	public void setRequiredCheckbox() {
		checkBoxRequired.click();
	}

	public void setShowTooltipCheckbox() {
		checkShowTooltip.click();
	}

	public void setInfoIconCheckbox() {
		checkInfoIcon.click();
	}

	public void setTooltipMsg(String tooltipMsg) {
		txtTooltipMsg.sendKeys(tooltipMsg);
	}

	public void clickSaveButton() {
		btnSave.click();
	}
	
	public void clickNextButton() {
		btnClickNext.click();
	}
	
	public void clickOkButton() {
		btnOkay.click();
	}
	
	public void clickFinishButton() {
		btnFinish.click();
	}
	



}
