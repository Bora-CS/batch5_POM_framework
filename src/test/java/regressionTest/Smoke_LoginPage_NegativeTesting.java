package regressionTest;


import org.testng.Assert;
import org.testng.annotations.Test;
import testData.TestingData;
import utilities.SetUpPage;

public class Smoke_LoginPage_NegativeTesting extends SetUpPage {
	
	@Test
	public void loginPage_negativeTesting() {
		login.clickSignInButton();
		login.fillEmailAddress(TestingData.Bora_351_wrongEmailAddress);
		login.fillPassword("");
		String message = login.getErrorMessageForEmail();
		Assert.assertEquals(message, TestingData.ExpectingErrorMessageForEmail);
		
		
		//-------------
		String messageForPassword = login.getErrorMessageForPassword();
		Assert.assertEquals(messageForPassword, TestingData.ExpectingErrorMessageForPassword);
		//=============
		
		
	}
	
	

}

