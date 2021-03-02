package practices;

import org.testng.annotations.Test;

public class OrderTest {

	
	@Test(groups = {"smoke","regression","order"})
	public void tset1() {
		System.out.println("This is Order - test 1");
	}
	
	@Test(groups = {"smoke","regression"})
	public void tset2() {
		System.out.println("This is Order - test 2");
	}
	
	@Test(groups="order")
	public void tset3() {
		System.out.println("This is Order - test 3");
	}
	
	@Test(groups="order")
	public void tset4() {
		System.out.println("This is Order - test 4");
	}
	
	@Test(groups="order")
	public void tset5() {
		System.out.println("This is Order - test 5");
	}
	
	
}
