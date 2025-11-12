package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MindmatrixLoginPage extends BasePage {

	public MindmatrixLoginPage(WebDriver driver) {
		super(driver);

	}

	@FindBy(xpath = "//input[@id='email']")
	WebElement txtEmailAddress;

	@FindBy(xpath = "//label[@class='input']//input[@id='password']")
	WebElement txtPassword;

	@FindBy(xpath = "//button[@id='btnLogin']")
	WebElement btnLogin;

	public void setEmail(String email) {
		txtEmailAddress.sendKeys(email);
	}

	public void setPassword(String pwd) {
		txtPassword.sendKeys(pwd);
	}

	public void clickLogin() {
		btnLogin.click();
	}

}
