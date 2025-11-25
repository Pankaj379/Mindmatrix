package testCases;

import org.testng.annotations.Test;

import pageObjects.CreateRecordPage;
import pageObjects.MindmatrixLoginPage;
import testBase.BaseClass;

public class TC0003_Create_New_Record extends BaseClass {


	@Test(groups= {"Sanity","Master"})
	void Create_Solution_Custom_Field() throws InterruptedException{

		logger.info("****** Starting TC0003_Create_New_Record*****");



		//Login
		MindmatrixLoginPage lp=new MindmatrixLoginPage(driver);
		lp.setEmail(pro.getProperty("email"));
		lp.setPassword(pro.getProperty("password"));
		lp.clickLogin();
		


		// Create New Record:
		CreateRecordPage cr = new CreateRecordPage(driver);
		cr.clickFolderDropdown();
		String lastValue = cr.selectLastDropdownValue();
		System.out.println("Selected Last Dropdown Value: " + lastValue);
		cr.clickCreateRecord();
		cr.setName("Test:" + randomNumber());
		cr.setDescription("This is to test the description.");
		cr.enablePrice();
		cr.setPrice("215");
		cr.clickFilterType();
		cr.clickFilter();
		cr.clickNextToSelectBanner();
		cr.clickNextToDetails();
		cr.setTextDetails("Test the text field.");
		cr.clickNextToRelatedAssets();

		cr.setFilterRelatedAssets("test"); 
		cr.selectFilterRelatedAsset();

		cr.clickNextToRelatedProducts();
		cr.clickOnFinish();

	}


}
