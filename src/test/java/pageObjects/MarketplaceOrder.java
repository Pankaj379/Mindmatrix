
package pageObjects;

import java.time.Duration;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MarketplaceOrder extends BasePage {

    private WebDriverWait wait;

    public MarketplaceOrder(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    //--------------------------------- Locators ---------------------------------

    @FindBy(xpath = "//li[1]//div[1]//div[4]//div[2]//button[1]")
    private WebElement addToCartBtn;

    @FindBy(xpath = "//i[@class='fal fa-shopping-cart']")
    private WebElement cartIcon;
    
    @FindBy(xpath = "//a[normalize-space()='Remove']")
    private WebElement btnValidateRemove;
    

    @FindBy(xpath = "//a[normalize-space()='Proceed to Buy']")
    private WebElement proceedToBuyBtn;
   

    @FindBy(xpath = "//div[@id='MsgBoxBack']//button[@id='bot2-Msg2-1']")
    private WebElement confirmYesBtn;

    //--------------------------------- Utility Actions ---------------------------------

    private void clickElement(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        scrollIntoView(element);

        try {
            element.click();
        } catch (Exception e) {
            // Fallback to JS click
            jsClick(element);
        }
    }

    private void scrollIntoView(WebElement element) {
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
    }

    private void jsClick(WebElement element) {
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].click();", element);
    }

    //--------------------------------- Page Actions ---------------------------------

    public void clickAddToCart() {
    	 wait.until(ExpectedConditions.visibilityOf(addToCartBtn));
         wait.until(ExpectedConditions.elementToBeClickable(addToCartBtn));
        clickElement(addToCartBtn);
    }

    public void clickOnCartIcon() {
    	 wait.until(ExpectedConditions.visibilityOf(cartIcon));
         wait.until(ExpectedConditions.elementToBeClickable(cartIcon));
        clickElement(cartIcon);
    }

    public void clickOnPlaceOrder() {
    	
    	// Adding wait explicitly before clicking
        wait.until(ExpectedConditions.visibilityOf(btnValidateRemove));
        wait.until(ExpectedConditions.elementToBeClickable(btnValidateRemove));
        clickElement(proceedToBuyBtn);
    
    }

    public void clickYesOnPlaceOrder() {
    	 wait.until(ExpectedConditions.visibilityOf(confirmYesBtn));
         wait.until(ExpectedConditions.elementToBeClickable(confirmYesBtn));
        clickElement(confirmYesBtn);
    }
}
