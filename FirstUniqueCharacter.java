package LeetCode;

import java.util.Scanner;

public class FirstUniqueCharacter {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String s = in.next();
		System.out.println(firstUniqChar(s));
	}
    public static int firstUniqChar(String s) {
        char[] chars = s.toCharArray();
        if(s==null||s.length()==0||s.length()==1)
        	return 0;
        for(int i=0;i<chars.length-1;i++) {
        	
        }
		return -1;
    }

}
