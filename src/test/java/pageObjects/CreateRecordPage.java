package pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateRecordPage extends BasePage {

	public CreateRecordPage(WebDriver driver) {
		super(driver);
	}


	@FindBy(xpath="//button[@aria-expanded='false']") 
	WebElement btnFolderDropdown;

	// ALL DROPDOWN VALUES <li class='solutiontypes'>

	@FindBy(xpath = "//li[@class='solutiontypes']")
	private List<WebElement> dropdownValues;


	@FindBy(xpath = "//a[@class='btn btn-primary btn-block btn-effect1 btn-primary-cta ']")
	WebElement btnCreateRecord;

	@FindBy(xpath = "//input[@id='name']")
	WebElement txtName;

	@FindBy(xpath = "//div[@class='note-editable custom-scroll']")
	WebElement txtDescription;

	//@FindBy(xpath = "//input[@id='thumbnail']")
	//WebElement btnImage;

	@FindBy(xpath = "//input[@id='name']")
	WebElement txtNameTitle;

	@FindBy(xpath = "//div[5]//div[1]//label[2]//i[1]")
	WebElement checkboxPrice;

	@FindBy(xpath = "//input[@id='price']")
	WebElement txtPrice;
	
	@FindBy(xpath = "(//a[normalize-space()='Test single localized filters:23/05/2025'])[1]")
	WebElement btnFilter;
	
	@FindBy(xpath = "//label[normalize-space()='Test english localized.']")
	WebElement checkboxFilterSelect;
	
	@FindBy(xpath = "//i[@class='btn-icon fa fa-angle-double-right']")
	WebElement btnNextToSelectBanner;












	//-------------------------------------Methods--------------------------------------------

	public void clickFolderDropdown() {

		WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(10));
		mywait.until(ExpectedConditions.elementToBeClickable(btnFolderDropdown)).click();
	}


	// Select last dropdown value dynamically
	public String selectLastDropdownValue() {

		// Wait for dropdown items
		WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(10));
		mywait.until(ExpectedConditions.visibilityOfAllElements(dropdownValues));

		// Dynamic XPath: last() dropdown element
		WebElement lastElement = driver.findElement(By.xpath("(//li[@class='solutiontypes'])[last()]"));

		// Scroll into view (required for your scrollable dropdown UI)
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", lastElement);

		String valueText = lastElement.getText().trim();
		lastElement.click();

		return valueText;
	}

	public void clickCreateRecord() {
		btnCreateRecord.click();
	}

	public void setName(String name) {
		txtName.sendKeys(name);
	}

	public void setDescription(String description) {
		txtDescription.sendKeys(description);
	}


	public void enablePrice() {
		checkboxPrice.click();
	}

	public void setPrice(String price) {
		txtPrice.sendKeys(price);
	}
	
	public void clickFilterType() {
		btnFilter.click();
	}
	public void clickFilter() {
		checkboxFilterSelect.click();
	}
	public void clickNextToSelectBanner() {
		btnNextToSelectBanner.click();
	}






}
