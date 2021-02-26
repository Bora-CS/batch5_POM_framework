package LilyPractice;

public class ChildClass extends ParentClass {
	public static void main(String[] args) {
		testOverride("123S","aaa");

	
	}
	public static void testOverride(){
		System.out.println("This is from child class 1");
	}
	public static void testOverride(String a, String b){
		System.out.println("This is from child class 2");
	}

}
