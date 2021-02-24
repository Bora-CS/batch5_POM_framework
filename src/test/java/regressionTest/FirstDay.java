package regressionTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import testData.Locators;
import testData.TestingData;
import utilities.SetUpPage;

public class FirstDay extends SetUpPage{

	

	


	@Test // Jira ID: Bora-327
	public void test_327() {

		header.changeStore(TestingData.Wilmington);

		header.fillSeachBox(TestingData.Bora_327_searchTerm);

		String name = plp.getProductNameByIndex(1);
		Assert.assertTrue(name.contains(TestingData.Bora_327_searchTerm));
	}

	// Jira id: Bora-324
	@Test(enabled = false)
	public void test_324() {

		// 2. Change store
		header.changeStore(TestingData.ManassasStore);

		// 3. Search for specific product
		header.fillSeachBox(TestingData.Bora_324_wineName);

		// 4. Verify product in PLP
		String name = plp.getProductNameByIndex(1);
		Assert.assertEquals(name, TestingData.Bora_324_wineName);
		// or
//		Assert.assertTrue(name.contains(TestingData.Bora_324_wineName));
	}

	@Test(enabled = false)
	public void firstTest() {

		// 2. Change store
		header.changeStore(TestingData.ManassasStore);


		// 3. Goto wine PLP - Product List page
		header.gotoWineDepartment();
		// verify we are successfully land on the PLP
		validate.verifyElementExist(Locators.winePLPHeader);

		// 4. Add first 5 products into cart
		plp.addMultipleProduct(5);


		// 5. Goto cart page
		header.gotoCartpage();
		
	}



}
