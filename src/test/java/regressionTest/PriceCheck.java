package regressionTest;

import org.testng.annotations.Test;

import dataDrivenTest.GetDataFromFile;
import utilities.SetUpPage;

public class PriceCheck extends SetUpPage{

	@Test(dataProvider = "dataSource", dataProviderClass = GetDataFromFile.class)
	public void checkPriceForFairfaxStore(String productId, String price) {
		
		System.out.println("test data is: "+productId+"   "+price);
		
		//Search for productId
		//and then on the PLP, check the price match with the test data
	}
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
