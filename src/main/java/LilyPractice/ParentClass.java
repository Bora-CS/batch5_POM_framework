package LilyPractice;

public class ParentClass {
	public static void testOverride(){
		System.out.println("This is from parent class");
	}
	public static void testOverride(String text){ //this is a method overloading 
		System.out.println("This is from parent class 2" + text);
	}
	public static void testOverride(String a, String b){
		System.out.println("This is from parent class 2");
	}


}
