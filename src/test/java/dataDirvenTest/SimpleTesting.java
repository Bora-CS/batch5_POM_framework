package dataDirvenTest;

import java.util.HashMap;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import testData.TestingData;

public class SimpleTesting {

	@DataProvider
	public Object[] dataSouce() {

		Object[] data = new Object[4];
		data[0] = "This is test data 1";
		data[1] = "This is test data2";
		data[2] = 100;
		data[3] = 200;
		return data;
	}

	@Test(dataProvider = "dataSouce")
	public void testDataRecevie(Object displayText) {

		System.out.println("This is testing data " + displayText);

	}
	
	@Test(dataProvider = "dataSouceForSpecificDataType")
	public void testSpecificDataType(Object data){
		 int totalPrice=5;
		 System.out.println("Testing data is :"+ data);
	}
	
	
	@DataProvider
	public Object [] dataSouceForSpecificDataType() {
		Object [] numbers= {1,2,3};
		return numbers;
	}
	
	
	public Object [] dataSouceForMutipleTest() {
		HashMap <String , Integer >data1 = new HashMap<String, Integer>();
		HashMap <String , Integer >data2 = new HashMap<String, Integer>();
		HashMap <String , Integer >data3 = new HashMap<String, Integer>();
		
		data1.put("qty", 3);
		

		return null;

		
	}
	
	
	
	
	
}
