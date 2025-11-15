package testCases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.CreateSolutionCustomField;
import pageObjects.MindmatrixLoginPage;
import pageObjects.Solution_Custom_page;
import testBase.BaseClass;

public class TC002_Create_Custom_Field extends BaseClass {

	@Test(groups= {"Sanity","Master"})
	void Create_Solution_Custom_Field() {

		logger.info("****** Startign TC_001_MindmatrixLoginTest *****");

		try
		{

			//Login
			MindmatrixLoginPage lp=new MindmatrixLoginPage(driver);
			lp.setEmail(pro.getProperty("email"));
			lp.setPassword(pro.getProperty("password"));
			lp.clickLogin();

			// Validate the Solution custom field page.
			Solution_Custom_page macc=new Solution_Custom_page(driver);
			boolean targetPage=macc.isSolCustomPageExists();



			// Assert take three parameters first two to verify and 3rd for message.

			Assert.assertTrue(targetPage); // Assert.assertEquals(targetPage, true,"Login failed"); 
		
		logger.info("****** Finished TC_001_MindmatrixLoginTest *****");


		CreateSolutionCustomField cs = new CreateSolutionCustomField(driver);

		// 1
		logger.info("*****Starting TC002_Create_Custom_Field*****");

		logger.info("Validating the Solution Custom Field.");
		String confmsg = cs.page_Valid_CreateRecord();
		if(confmsg.equals("Solution Custom Fields")){
			Assert.assertTrue(true);
		}else {
			logger.error("Test failed...");
			logger.debug("debug logs..");
			Assert.assertTrue(false);
		}

		// 2
		logger.info("CLick on the create button of solution custom field..");
		cs.clickCreate();

		// 3
		logger.info("Add the title of the Soluton custom field..");
		cs.setFolderName(randomAlphaNumberic().toUpperCase());

		// 4
		logger.info("Add the description of Soluton custom field..");
		cs.setDescription("Test description");
		
		//
		/*
		 * logger.info("Add the filter dropdown value");
		 * cs.selectFilterOption("test12");
		 */

		// 5
		logger.info("Click on on the next button..");
		cs.clickNext();

		// 6
		logger.info("Click on the edit custom field folder name..");
		cs.clickEditCustomFolder();

		// 7
		logger.info("Edit the solution custom field folder name");
		cs.setFolderName("567");

		// 8
		logger.info("Edit the localized solution custom field folder name for english");
		cs.setLocalFolderName("Localizeda_English_text");

		// 9
		logger.info("Click on the custom field folder save button");
		cs.clickSave();

		// 10
		logger.info("Click on the add custom field");
		cs.clickEditCustomField();

		// 11
		logger.info("Select the custom field value from dropdown field");
		cs.selectFieldType("Text");
		
		// 12
		
		cs.setFieldDisplayName("Test34");
		
		cs.setFieldParseName("test342q");
		
		cs.setMinCharLimit("3");
		
		cs.setMaxCharLimit("128");
		
		cs.setRequiredCheckbox();
		
		cs.setShowTooltipCheckbox();
		
		cs.setTooltipMsg("This is text field tooltip..");
		
		cs.clickSaveButton();
		
		cs.clickNextButton();
		
		cs.clickOkButton();
		
		cs.clickFinishButton();
		
		}
		catch(Exception e)
		{
			Assert.fail();
		}

	}

}
