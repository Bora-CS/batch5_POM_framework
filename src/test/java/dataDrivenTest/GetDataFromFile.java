package dataDrivenTest;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class GetDataFromFile {

	
	
	@DataProvider
	public Object[][] dataSource() {

		try {
			FileReader f = new FileReader("src/test/resources/productIdAndPrice");

			BufferedReader reader = new BufferedReader(f);

			String line=null;
//			Object[] data = new Object[2];
			List<Object[]> datas = new ArrayList();
			
			
			while ((line=reader.readLine()) != null) {
				System.out.println("this is from file: " + line);
				
				Object[] data = new Object[2];  //--> make data = null
				data[0] = line.split("-")[0].trim();
				data[1] = line.split("-")[1].trim();
				datas.add(data);
				
			}
			
			
			
			int size = datas.size();
			Object[][] returnData = new Object[size][2];
			for(int i=0; i<size; i++) {
				returnData[i] = datas.get(i);
			}
			
			
			return returnData;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
	@Test()
	public void test() {

		
		
		String a = "java";
		String b = "java";
		String c = new String("java");
		String d = new String("java");
		
		a.equals(c);
		
		System.out.println("a and b "+a==b);
		System.out.println("c and d "+c==d);
		

	}
	
	
	@Test(dataProvider = "dataSource", enabled = false)
	public void test(String productId, String price) {

		System.out.println("test data is: "+productId+"   "+price);
		
		
		String a = "java";
		String b = "java";
		String c = new String("java");
		String d = new String("java");
		

	}

}
