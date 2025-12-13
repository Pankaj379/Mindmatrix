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
	
	@FindBy(xpath = "//ul[@class='navbar-nav navbar-right']//i[@id='usericon']")
	WebElement btnProfile;
	
	
	@FindBy(xpath = "//span[normalize-space()='Log out']")
	WebElement btnLogout;
	
	
	@FindBy(xpath = "//div[@id='MsgBoxBack']//button[@id='bot2-Msg1']")
	WebElement btnSessionLogout;
	

	public boolean isSolCustomPageExists() {
		try {
			return (msgHeading.isDisplayed());
		} catch (Exception e) {
			return false;
		}
	}
	
	public void clickProfileToLogout() {
		btnProfile.click();
	}
	
	public void clickOnLogout() {
		btnLogout.click();
	}
	
	public void clickOnCurrentSessionLogout() {
		btnSessionLogout.click();
	}
	
	
}
