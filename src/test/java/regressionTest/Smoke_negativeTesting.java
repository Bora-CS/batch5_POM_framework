package regressionTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

import org.testng.annotations.BeforeClass;

import org.testng.annotations.Test;


import pages.HeaderComponet;

import pages.SignInPage;
import testData.TestingData;
import utilities.SetupPage;
import utilities.UtilityLibrary;


public class Smoke_negativeTesting extends SetupPage {

	
	@Test (priority =1)
	public void bora_315(){
		header.loginButton(); 
		sip.signIn_fillEmail(TestingData.invalid_email);
		sip.clickLoginButton();
		String text = sip.errorMessage_Email();
		Assert.assertEquals(text, TestingData.expectedErrorEmailMessage);
	}
	
	@Test (priority =2)
	public void bora_signInFail(){
		header.loginButton();
		sip.signIn_fillEmail(TestingData.test_Email);
		sip.signIn_fillPassword(TestingData.test_Password);
		sip.clickLoginButton();
		String signInFail = sip.errorMessage_signInFail();
		Assert.assertEquals(signInFail, TestingData.signInDisableMessage);
	}
	
	@Test (priority =3)
	public void bora_test(){	
	}
	
	@BeforeClass
	public void startTest(){
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
		driver = new ChromeDriver ();

		lib = new UtilityLibrary(driver);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(TestingData.HomePageURL);
		
		header = new HeaderComponet();
		sip = new SignInPage();
	}
	
	@AfterClass
	public void endTest(){
		driver.quit();
	}
}
