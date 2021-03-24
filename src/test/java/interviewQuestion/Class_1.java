package interviewQuestion;

import java.util.HashMap;

public class Class_1 {

	public static void main(String[] args) {

		String text = "I like Java";

//		String result = reverseWithoutBuildInMethod(text);
//		System.out.println("\nreturn result is: "+result);
		String sentence = "Wine & Spirits-Spain- More fruity than dry, this 'extreme brut' is filled with soft peach and nut Flavors their "
				+ "fragrance lifted by floral tones of white lilies. Briny and fresh, the flavors last. Fantastic with shrimp tempura.";
//		countWord(sentence);

		swapNumberWithTemporaryVar(7, 11);
		swapNumberWithoutTemporaryVar(7, 11);

//		fizzBuzz(50);
		
		System.out.println("expecting number is: "+fibanacciNumber_1(10));
		System.out.println("expecting number is: "+fibanacciNumber_2(10));
	}
	
	
	
	public static int fibanacciNumber_2(int expectingNumber) { // 5 --> 5th number,  3 -> 3rd number
		
		if(expectingNumber<=1) return 0;
		if(expectingNumber==2) return 1;
		
		
		int twoNumberBefore =0;
		int oneNumberBefore =1;
		int result=0;
		for(int i=2; i<expectingNumber;i++) {
			
			result = twoNumberBefore + oneNumberBefore;

			twoNumberBefore = oneNumberBefore;
			oneNumberBefore = result;

		}
		return result;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static int fibanacciNumber_1(int expecintNumber) {

		if(expecintNumber<=1) return 0;
		if(expecintNumber==2) return 1;
		
		int[] nums = new int[expecintNumber];
		nums[0]=0;nums[1]=1;
		
		for(int i=2; i<expecintNumber; i++) {
			
			nums[i] = nums[i-1] + nums[i-2];
			
		}
		return nums[expecintNumber-1];
	}
	
	

	public static void fizzBuzz(int endNumber) {

		// n%3 Fizz, n%11 Buzz, n%3/11 FizzBuzz

		for (int number = 1; number <= endNumber; number++) {

			if (number % 3 == 0 && number % 11 == 0) {
				System.out.println("This number is " + number + " FizzBuzz");
			} else if (number % 3 == 0) {
				System.out.println("This number is " + number + " Fizz");
			} else if (number % 11 == 0) {
				System.out.println("This number is " + number + " Buzz");
			}

		}

	}

	public static void swapNumberWithoutTemporaryVar(int a, int b) {

		// get total of the a & b, like a=7, b=11, then total will be 18
		// assign the total to one of the variable --> a=18, b=11
		// when we use total to minus the un-changed variable
		// --> a - b = 18-11 = 7
		// the minused value is the target value of b, so
		// --> b = a-b = 18-11 = 7
		// Now, we get one of the target value, which is b,
		// So, we need to get a this time, which we want a = 11
		// we only able to get 11 by total - changed value = 18 - 7 = 11 = a-b
		// a = 18-7 = a-b =11

		a = a + b;
		b = a - b;
		a = a - b;
		System.out.println("After swap, a = " + a + " b = " + b);

	}

	public static void swapNumberWithTemporaryVar(int a, int b) {

		// Temporary var --> temp
		// give a's value to temp
		int temp = a;

		// give b's value to a
		a = b;
		// give temp's value to b
		b = temp;

		System.out.println("After swap, a = " + a + " b = " + b);

	}

	// count word in the sentence
	// This question is a specific exercise that will show your knowledge of using
	// Java code to complete a task. Exercise questions have a specific correct
	// answer the interviewer is looking for.

	public static void countWord(String text) {
		// This question is a specific exercise
		// string -> split by " " -> list of the word - String[]

		// This -> 3 question -> 2 is -> 5
		// hashMap --> uniqie

		String[] stringArray = text.split(" ");

		HashMap<String, Integer> map = new HashMap<String, Integer>();

		// loop thought the array,
		// I like Java and Jave love Java
		for (String temp : stringArray) {
			// add a word into map
//			map.put(temp, 1);
			if (map.containsKey(temp)) {
				// increase value -> map.getvalue(key)
				int newValue = map.get(temp) + 1;
				map.replace(temp, newValue);
			} else {
				map.put(temp, 1);
			}

		}

		System.out.println(map.toString());
	}

	public static String reverseWithoutBuildInMethod(String text) {

		// input output
		// I like Java --> avaJ ekil I
		// avaJ e
		// loop -->int i , condition (length of the string)
		// this loop will run 11 times (String.length)
		// we should start from the last one,
		// for( int i= lengthOfTheString / 0; i>0,i<length ; i-- )

		// get charter of the string and printout
		int len = text.length();
		for (int i = len - 1; i >= 0; i--) {
			System.out.print(text.charAt(i));
		}

		System.out.println("");
		for (int i = 1; i <= len; i++) {
			// I like Java
			// len-i = 11 - 0 =11
			System.out.print(text.charAt(len - i));
		}

		// convert string to array, can we array to string
		// String --> String[], String[] --> String
//		String result="";
		char[] charArray = new char[len];
		for (int i = len - 1; i >= 0; i--) {

			// add this char into new String/Array
//			result = result + text.charAt(i);
			// String[] + char
			charArray[len - i - 1] = text.charAt(i);
		}

		return String.valueOf(charArray);

	}

	public static void reverseWithBuildInMethod() {
		// StringBuilder / StringBuffer
		StringBuilder sbuilder = new StringBuilder("I like Java");

		sbuilder.reverse();

		System.out.println(sbuilder);

		StringBuffer sbuffer = new StringBuffer();
		sbuffer.append("I like Java");
		sbuffer.reverse();
		System.out.println(sbuffer);

	}

}
