package practices;

import org.testng.annotations.Test;

public class LoginTest {

	@Test(groups = "regression")
	public void tset1() {
		System.out.println("This is loginTest - test 1");
	}
	
	@Test(groups = {"smoke","login"})
	public void tset2() {
		System.out.println("This is loginTest - test 2");
	}
	
	@Test(groups = {"smoke","login"})
	public void tset3() {
		System.out.println("This is loginTest - test 3");
	}
	
	@Test(groups = "login")
	public void tset4() {
		System.out.println("This is loginTest - test 4");
	}
	
	@Test(groups = "login")
	public void tset5() {
		System.out.println("This is loginTest - test 5");
	}
	
	
}
