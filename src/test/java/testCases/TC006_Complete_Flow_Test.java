package testCases;

import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.CreateRecordPage;
import pageObjects.CreateSolutionCustomField;
import pageObjects.MarketplaceOrder;
import pageObjects.MindmatrixLoginPage;
import pageObjects.Solution_Custom_page;
import testBase.BaseClass;

public class TC006_Complete_Flow_Test extends BaseClass {

	@Test(groups = { "Sanity", "Master" })
	void completeRegressionRun() {

		logger.info("****** Starting TC006_Complete_Flow_Test ******");

		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			// ===================== Login =====================
			MindmatrixLoginPage lp = new MindmatrixLoginPage(driver);
			lp.setEmail(pro.getProperty("email"));
			lp.setPassword(pro.getProperty("password"));
			lp.clickLogin();

			// ===================== Validate Solution Custom Field Page =====================
			Solution_Custom_page scp = new Solution_Custom_page(driver);
			boolean isTargetPageDisplayed = scp.isSolCustomPageExists();

			Assert.assertTrue(isTargetPageDisplayed, "Solution Custom Field page is not displayed");

			logger.info("Login successful and Solution Custom Field page validated");

			// ===================== Create Solution Custom Field =====================
			CreateSolutionCustomField cs = new CreateSolutionCustomField(driver);

			logger.info("***** Starting creation of Solution Custom Field *****");

			String pageHeader = cs.page_Valid_CreateRecord();
			Assert.assertEquals(pageHeader, "Solution Custom Fields", "Incorrect page header");

			logger.info("Clicking on Create button");
			cs.clickCreate();

			logger.info("Entering Solution Custom Field title");
			cs.setFolderName(randomAlphaNumberic().toUpperCase());

			logger.info("Entering Solution Custom Field description");
			cs.setDescription("Test description");

			logger.info("Clicking on Next button");
			cs.clickNext();

			logger.info("Editing custom field folder name");
			cs.clickEditCustomFolder();
			cs.setFolderName("567");

			logger.info("Setting localized folder name (English)");
			cs.setLocalFolderName("Localized_English_Text");

			logger.info("Saving custom field folder");
			cs.clickSave();

			logger.info("Adding new custom field");
			cs.clickEditCustomField();

			logger.info("Selecting custom field type");
			cs.selectFieldType("Text");

			cs.setFieldDisplayName("Test34");
			cs.setFieldParseName("test342q");
			cs.setMinCharLimit("3");
			cs.setMaxCharLimit("128");
			cs.setRequiredCheckbox();
			cs.setShowTooltipCheckbox();
			cs.setTooltipMsg("This is a text field tooltip");

			cs.clickSaveButton();
			cs.clickNextButton();
			cs.clickOkButton();
			cs.clickFinishButton();

			logger.info("****** Solution Custom Field created successfully ******");

			// ===================== Create New Record =====================
			logger.info("***** Starting New Record creation *****");

			driver.navigate().to(pro.getProperty("appURL2"));

			CreateRecordPage cr = new CreateRecordPage(driver);
			cr.clickFolderDropdown();

			String lastValue = cr.selectLastDropdownValue();
			logger.info("Selected dropdown value: " + lastValue);

			cr.clickCreateRecord();
			cr.setName("Test-" + randomNumber());
			cr.setDescription("This is to test the description");
			cr.enablePrice();
			cr.setPrice("215");
			cr.clickFilterType();
			cr.clickFilter();
			cr.clickNextToSelectBanner();
			cr.clickNextToDetails();
			cr.setTextDetails("Testing text field");
			cr.clickNextToRelatedAssets();

			cr.setFilterRelatedAssets("test");
			cr.selectFilterRelatedAsset();

			cr.clickNextToRelatedProducts();
			cr.clickOnFinish();

			logger.info("***** New Record created successfully *****");

			// ===================== Place Order from Marketplace =====================
			logger.info("***** Starting Marketplace Order flow *****");

			driver.navigate().to(pro.getProperty("appURL3"));

			MarketplaceOrder placeOrder = new MarketplaceOrder(driver);

			placeOrder.clickAddToCart();
			logger.info("Added item to cart");

			placeOrder.clickOnCartIcon();
			logger.info("Opened cart");

			placeOrder.clickOnPlaceOrder();
			logger.info("Clicked Place Order");

			placeOrder.clickYesOnPlaceOrder();
			logger.info("Order placed successfully");

			logger.info("****** TC006_Complete_Flow_Test completed successfully ******");

		} catch (Exception e) {
			logger.error("Test execution failed", e);
			Assert.fail("Test failed due to exception: " + e.getMessage());
		}
	}
}
