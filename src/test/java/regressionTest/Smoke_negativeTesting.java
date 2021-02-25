package regressionTest;

import org.testng.Assert;
import org.testng.annotations.Test;


import testData.TestingData;
import utilities.SetupPage;

public class Smoke_negativeTesting extends SetupPage {

	
	@Test(enabled=false)
	public void bora_315(){
		header.loginButton(); // failed! because NOT human 
		sip.signIn_fillEmail(TestingData.invalid_email);
		sip.clickLoginButton();
		String text = sip.errorMessage_Email();
		Assert.assertEquals(text, TestingData.expectedErrorEmailMessage);
	}
	@Test
	public void bora_signInFail(){
		header.loginButton(); // failed, I think the website know I am automating it.
		sip.signIn_fillEmail(TestingData.test_Email);
		sip.signIn_fillPassword(TestingData.test_Password);
		sip.clickLoginButton();
		String signInFail = sip.errorMessage_signInFail();
		Assert.assertEquals(signInFail, TestingData.signInDisableMessage);
	}
}
