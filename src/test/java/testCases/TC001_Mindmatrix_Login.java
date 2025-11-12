package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.MindmatrixLoginPage;
import pageObjects.Solution_Custom_page;
import testBase.BaseClass;

public class TC001_Mindmatrix_Login extends BaseClass {
	
	
	@Test(groups= {"Sanity","Master"})
	public void verify_login()
	{
		logger.info("****** Startign TC_001_MindmatrixLoginTest *****");
		
		try
		{
	
		//Login
			MindmatrixLoginPage lp=new MindmatrixLoginPage(driver);
		lp.setEmail(pro.getProperty("email"));
		lp.setPassword(pro.getProperty("password"));
		lp.clickLogin();
		
		//MyAccount
		Solution_Custom_page macc=new Solution_Custom_page(driver);
		boolean targetPage=macc.isSolCustomPageExists();
		
		
		
		// Assert take three parameters first two to verify and 3rd for message.
		
		Assert.assertTrue(targetPage); // Assert.assertEquals(targetPage, true,"Login failed"); 
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		logger.info("****** Finished TC_001_MindmatrixLoginTest *****");
	}
	
	

}
