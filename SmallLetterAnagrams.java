import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SmallLetterAnagrams {

	
	public static int numberNeeded(String first, String second) {
		
		int number = 0;
		int[] firstString = new int[26];
		int[] secondString = new int[26];
		createArrafromString(firstString, first);
		createArrafromString(secondString, second);
		for(int i=0; i<26; i++) {
			number = number + Math.abs(firstString[i]-secondString[i]);
		}
		return number;
	}
	
	private static void createArrafromString(int[] secondString, String str) {
//		
//		for(int i=0; i<26; i++) {
//			secondString[i]=0;
//		}
		for(char eachChar: str.toCharArray()) {
			secondString[eachChar-97] = secondString[eachChar-97]+1;
		}
		
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String a = in.next();
		String b = in.next();
		System.out.println(numberNeeded(a, b));
	}
	
}
