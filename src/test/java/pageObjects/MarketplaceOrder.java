package pageObjects;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MarketplaceOrder extends BasePage {

	public MarketplaceOrder(WebDriver driver) {
		super(driver);
	}

	//----------------------------X-Paths---------------------------------

	@FindBy(xpath="//li[1]//div[1]//div[4]//div[2]//button[1]") 
	WebElement AddToCart;

	@FindBy(xpath="//i[@class='fal fa-shopping-cart']") 
	WebElement btnCart;



	//-------------------------------------Methods--------------------------------------------

	public void clickAddToCart() {
		WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(10));
		mywait.until(ExpectedConditions.visibilityOfAllElements(AddToCart));
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", AddToCart);
		AddToCart.click();
	}

	public void clickOnCartIcon() {
		// Wait for items
		WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(10));
		mywait.until(ExpectedConditions.visibilityOfAllElements(btnCart));
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", btnCart);
		btnCart.click();
	}

}
