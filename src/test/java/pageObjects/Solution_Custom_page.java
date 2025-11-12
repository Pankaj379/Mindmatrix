package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

//h1[normalize-space()='Solution Custom Fields']
public class Solution_Custom_page extends BasePage {

	public Solution_Custom_page(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//h1[normalize-space()='Solution Custom Fields']") // Sol Custom Page heading
	WebElement msgHeading;

	public boolean isSolCustomPageExists() {
		try {
			return (msgHeading.isDisplayed());
		} catch (Exception e) {
			return false;
		}
	}

}
