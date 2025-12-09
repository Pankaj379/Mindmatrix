package testCases;

import org.testng.annotations.Test;

import pageObjects.MarketplaceOrder;
import pageObjects.MindmatrixLoginPage;
import testBase.BaseClass;

public class TC0004_Place_An_Order extends BaseClass {


	@Test(groups= {"Sanity","Master"})
	void Create_Solution_Custom_Field() throws InterruptedException{

		logger.info("****** Starting TC0004_Place_An_Order*****");



		//Login
		MindmatrixLoginPage lp=new MindmatrixLoginPage(driver);
		lp.setEmail(pro.getProperty("email"));
		lp.setPassword(pro.getProperty("password"));
		lp.clickLogin();
		


		// Create New Record:
		MarketplaceOrder placeOrd = new MarketplaceOrder(driver);
		
		logger.info("******Click on the record Add to cart button*****");
		placeOrd.clickAddToCart();
		logger.info("******Click on cart Icon*****");
		placeOrd.clickOnCartIcon();
		logger.info("******Click on place an order button*****");
		placeOrd.clickOnPlaceOrder();
		logger.info("******Click on Yes of popup place an order button*****");
		placeOrd.clickYesOnPlaceOrder();
		
		

	}


}
