package dataDrivenTest;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SimpleTesting {

	
	@DataProvider
	public Object[] dataSource() {
		
		Object[] data = new Object[5];
		data[0] = "dataFromDataSource";
		data[1] = "secondData";
		data[2] = 123;
		data[3] = 345;
		data[4] = false;
		return data;
	}
	
	
	@Test(dataProvider = "dataSource", enabled=false)
	public void testDataReceive(Object displayText) {
		
		System.out.println("this is testing data: "+displayText);
	}
	
	
	
	
	
	
	
	
	
	
	@Test(dataProvider = "dataSourceForSpecificDataType", enabled = false)
	public void testSpecificDataType(int price) {
		
		int totalPrice = 5 * price;
		System.out.println("Testing data is: "+totalPrice);
		
	}
	
	@DataProvider
	public Object[] dataSourceForSpecificDataType() {
		Object[] numbers = {1,2,34,356,435};
		return numbers;
	}
	
	
	
	
	
	
	
	@Test(dataProvider = "test3", enabled = false)
	public void testToSendMultipleTestData(Object[] product) { // int qty, int price
		int qty = (int) product[0];
		int price = (int) product[1];
		int sum = qty * price;
		System.out.println("the sum is: "+sum);
	}
	
	
	
	@DataProvider(name = "test3")
	public Object[][] dataSourceForMultipleTestData() {
		
		Object[] sum1 = {3, 9, 1234665};
		Object[] sum2 = {5, 12, 1234948};
		Object[] sum3 = {12, 9, 348572};
		
		//Must return either Object[]  or Object[][]
		Object[][] data = {sum1,sum2,sum3};
		return data;
	}
	
	
	
	
	@Test(dataProvider = "dataSourceForMultipletest")
	public void test4(HashMap<String, Integer> data) {

		int sum = data.get("qty") * data.get("price");
		System.out.println("sum is: "+sum);	
	}
	
	@Test(dataProvider = "dataSourceForMultipletest")
	public void test5(HashMap<String, Integer> data) {
		
		int productId = data.get("productId");
		int price = data.get("price");
		// do some UI validation
		System.out.println("UI validation: "+productId+"  "+price);
		
	}
	
	
	@DataProvider
	public Object[] dataSourceForMultipletest() {
		
		// { qty,  price,  productId}
		// testcase-1 --> qty and price
		// testcase-2 --> productId and price
		
		HashMap<String, Integer> data1 = new HashMap<String, Integer>();
		HashMap<String, Integer> data2 = new HashMap<String, Integer>();
		HashMap<String, Integer> data3 = new HashMap<String, Integer>();
		
		data1.put("qty", 3);
		data1.put("price",9);
		data1.put("productId",1234665);
		
		data2.put("qty", 5);
		data2.put("price",12);
		data2.put("productId",1234948);
		
		data3.put("qty", 12);
		data3.put("price",9);
		data3.put("productId",348572);
		
		Object[] returnData = {data1, data2, data3};
 		return returnData;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
