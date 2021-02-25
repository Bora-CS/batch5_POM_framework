package regressionTest;


import org.testng.Assert;

import org.testng.annotations.Test;


import testData.Locators;
import testData.TestingData;
import utilities.SetupPage;


public class FirstDay extends SetupPage{
	
	
	@Test
	public void firstTest() {
		header.changStore(TestingData.ManassasStore);
		lib.clickElement(Locators.wineDepartment);
		lib.waitTime(2);
		app.verifyElement(TestingData.winePageH1Text);
		app.addItemToCart(5);
		lib.clickElement(Locators.cartIcon);
	}
	
	@Test
	public void test_324() {
		header.changStore(TestingData.ManassasStore); //change store
		header.fillSearchBox(TestingData.bora_324wineName); // search for specific product
		String productName = plp.getProductName(1).toLowerCase(); // verify product in plp
		Assert.assertTrue(productName.contains(TestingData.bora_324wineName.toLowerCase()));
	}
	
	@Test
	public void test_327(){
		header.changStore(TestingData.WilmingtonStore);
		header.fillSearchBox(TestingData.bora_327productName);
		String productName =plp.getProductName(1);
		Assert.assertTrue(productName.contains(TestingData.bora_327productName));
	}
	
	@Test
	public void test_342(){
		header.changStore(TestingData.FairfaxStore);
		header.fillSearchBox(TestingData.winePageH1Text);
		plp.sortProduct(2);
	}
}
