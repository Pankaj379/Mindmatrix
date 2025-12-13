package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.MindmatrixLoginPage;
import pageObjects.Solution_Custom_page;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC005_Mindmatrix_DDT extends BaseClass {


	@Test(dataProvider="LoginData", dataProviderClass=DataProviders.class , groups="DataDriver")
	public void verify_login(String email, String pwd, String exp) throws InterruptedException
	{
		logger.info("****** Startign TC005_Login_DDT *****");

		try
		{

			//Login
			MindmatrixLoginPage lp=new MindmatrixLoginPage(driver);
			lp.setEmail(email);
			lp.setPassword(pwd);
			lp.clickLogin();

			//Solution Custom Page Validation
			Solution_Custom_page macc=new Solution_Custom_page(driver);
			boolean targetPage=macc.isSolCustomPageExists();



			if(exp.equalsIgnoreCase("Valid"))
			{
				if(targetPage==true) // Data is valid  - login success - test pass  - logout
				{			
					macc.clickProfileToLogout();
					macc.clickOnLogout();
					Assert.assertTrue(true);

				}
				else
				{
					Assert.assertTrue(false); // login failed - test fail
				}
			}

			if(exp.equalsIgnoreCase("Invalid")) // getting valid/invalid from excel sheet.
			{
				if(targetPage==true) // login success - test fail  - logout
				{
					macc.clickProfileToLogout();
					macc.clickOnLogout();
					Assert.assertTrue(false);

				}
				else
				{
					Assert.assertTrue(true); // login failed - test pass
				}
			}


			Assert.assertTrue(targetPage); // Assert.assertEquals(targetPage, true,"Login failed"); 
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		Thread.sleep(2000);
		logger.info("****** Finished TC005_Login_DDT *****");
	}



}
