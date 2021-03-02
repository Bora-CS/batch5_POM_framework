package batch5_Framework_quiz;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import testData.TestingData;

public class Quiz_Test extends Quiz_SetUpPage{

	
	
	@Test
	public void quiz() {

//		Done - 1.Go to Totalwine.com   
//		Done - 2.Change store to ‘Laurel, MD’
//		Done - 3.Search for ‘hennessy vs cognac’
//		4.In the Product List page(PLP), check FIRST product price
//			1.If product size is 1.75L, then price should be $89.99
//			2.If product size is 750ml, then price should be $39.99
	
		header.changeStore(TestingData.LaurelStore);
		header.fillSeachBox(TestingData.Quzi_Hennessy);
		
//		String[] products = plp.getProductSizeAndPrice(0);
		
//		if(products[0].equals("1.75L")) {
//			Assert.assertEquals(products[1], "$89.99");
//		}
		
		HashMap<String, String> products = plp.getProductSizeAndPrice(0);
		
		if(products.get("size").equals("1.75L")) {
			Assert.assertEquals(products.get("price"), "$89.99");
		}else {
			Assert.assertEquals(products.get("price"), "$39.99");
		}
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
