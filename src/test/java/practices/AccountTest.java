package practices;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AccountTest {


	@BeforeTest
	public void testBeforeTest() {
		System.out.println("this is before test method");
	}
	
	@AfterClass
	public void testAfterClass() {
		System.out.println("this is after class method");
	}
	
	@BeforeGroups
	public void startGroup() {
		System.out.println("this is before group method");
	}
	
	@AfterSuite
	public void testAfterSuite() {
		System.out.println("this is after suite method");
	}
	
	
	
	@Test(groups = "account")
	public void tset1() {
		System.out.println("This is AccountTest - test 1");
	}
	
	@Test(groups = {"smoke","account"})
	public void tset2() {
		System.out.println("This is AccountTest - test 2");
	}
	
	@Test(groups = "account")
	public void tset3() {
		System.out.println("This is AccountTest - test 3");
	}
	
	@Test(groups = {"smoke","regression","account"})
	public void tset4() {
		System.out.println("This is AccountTest - test 4");
	}
	
	@Test(groups = "account")
	public void tset5() {
		System.out.println("This is AccountTest - test 5");
	}
	
}
