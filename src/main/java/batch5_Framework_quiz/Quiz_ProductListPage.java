package batch5_Framework_quiz;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;

import testData.Locators;

public class Quiz_ProductListPage extends Quiz_SetUpPage{

	
	public HashMap<String, String> getProductSizeAndPrice(int index) {
		
		List<WebElement> productSizes = lib.getListOfElements(Locators.plp_listOfProductSize);
		List<WebElement> productPrices = lib.getListOfElements(Locators.plp_listOfProductPrice);

		String size = productSizes.get(index).getText();
		String price = productPrices.get(index).getText();
				
		HashMap<String,String> data = new HashMap<String,String>();
		data.put("size", size);
		data.put("price", price);
		return data;
		
	}
	
	
}
