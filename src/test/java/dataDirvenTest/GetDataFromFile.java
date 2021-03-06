package dataDirvenTest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class GetDataFromFile {

	@DataProvider
	public Object[][] dataSouce() {

		try {
			FileReader f = new FileReader("src\\test\\resources\\getdata.txt");

			BufferedReader reader = new BufferedReader(f);// use bufferReader because we wanna use the method call readLine()

			String line = null;//store data in line,use this var in the loop

			Object[] data = new Object[2];
			List<Object[]> datas = new ArrayList();//can't use LIST ??
			while ((line = reader.readLine()) != null) {
			                     // readeLine() only call once at each loop
				
				data=new Object[2];//????? return null????why????
				data[0]=line.split("-")[0].trim();//product ID
				data[1]=line.split("-")[1].trim();// price 

				// store line into List 
				datas.add(data);
			}
			// store data into the flexible data structure
			int size  = datas.size();
			Object[][] returnData= new Object[size][2];
			for (int i = 0; i < size; i++) {
			//  ????????????????
				returnData[i]=datas.get(i);//??read the data
			}
			return returnData;
			
		} catch (Exception e) {

			e.getStackTrace();
		}

		return null ;
	}
	@Test(dataProvider = "dataSouce")
	public void test(String productId,String price) {
		
		System.out.println("test data is  :"+productId+" "+ price );
	}

}
