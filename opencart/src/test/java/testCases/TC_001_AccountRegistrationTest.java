package testCases;
 


import org.testng.Assert;
import org.testng.annotations.*;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass {

	@Test
	public void verify_account_registration()
	{
		logger.info("*** Starting TC_001_AccountRegistrationTest ***");
		try 
		{
			
		HomePage hp = new HomePage(driver);
		hp.clickRegister();
		logger.info("Clicked on Register Link");
		
		logger.info("Entering customer Details");
		AccountRegistrationPage regpage = new AccountRegistrationPage(driver);
		
		regpage.setChkBox();
		regpage.setFirstname(randomString().toUpperCase());
		regpage.setLastname(randomString().toLowerCase());
		regpage.setDate("15");
		regpage.setMonth("January");
		regpage.setYear("2020");
		regpage.setEmail(randomString()+"@gmail.com");
		regpage.setCompanyName(randomString());
		
		String password = randomAlphaNumeric();
		
		regpage.setPassword(password);
		regpage.setConfirmPassword(password);
		
		regpage.clickRegister();
		logger.info("Clicked on Register");
		 		
		String confirmMsg = regpage.getConfirmationMsg();
		
		logger.info("Validating Expected Message....");
		Assert.assertEquals(confirmMsg,"Your registration completed");
		
		}
		
		catch (Exception e) {
			logger.error("Test Failed",e);
			e.printStackTrace();
			Assert.fail("Test failed due to an exception:"+e.getMessage());
		}
		logger.info("**** Finished TC_001_AccountRegistration ****");
		 }

	    
	
	
	
	
	
	
	
	
}
