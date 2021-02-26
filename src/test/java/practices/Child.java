package practices;

public class Child extends Parent{

	
	
	public static void main(String[] args) {

		startTest();
		
		testOverride();
	
	}
	
	//@BeforeClass
	public static void startTest() {
		
		//open browser
	}
	
	
	
	public static void testOverride() {
		System.out.println("This method come from Child");
	}
	
	
	
}
