/**
 * 
 */
package LeetCode;

import java.util.HashMap;

/**
 * @author megha
 *
 */
public class LongestPalindromeSubstr {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<String, String> map = new HashMap<>();
		System.out.println(longestPalindrome("civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth", map));
	}
	
	public static String longestPalindrome(String s, HashMap<String, String> map) {
				
		if(s==null || s.equals(""))
			return null;
		
		if(map.containsKey(s))
			return map.get(s);
		
		if(s.length()==1) 
			{
			map.put(s, s);
			return s;
			}
		
		if(s.length()>0) {
			int mid = (s.length())/2;
			for(int i=0; i<mid; i++) {
				if(s.charAt(i)!=s.charAt(s.length()-1-i))
					{
					break;
					}
					if(i == mid-1) {
					map.put(s, s);
					return s;
				}
			}
		}
		String leftPart = s.substring(0,s.length()-1);
		String rightPart =s.substring(1);
		String leftPalin = longestPalindrome(leftPart,map);
		String rightPalin =longestPalindrome(rightPart,map);
		
		String answer = null; 
		if(leftPalin!=null&&rightPalin!=null) {
			answer=leftPalin.length()>rightPalin.length()?leftPalin:rightPalin;
		}else if(leftPalin!=null) {
		answer = leftPalin;
		}else {
			answer=rightPalin;
		}
		map.put(s, answer);
		return answer;
	}
	
	private int lo, maxLen;

	public String longestPalindrome(String s) {
		int len = s.length();
		if (len < 2)
			return s;
		
	    for (int i = 0; i < len-1; i++) {
	     	extendPalindrome(s, i, i);  //assume odd length, try to extend Palindrome as possible
	     	extendPalindrome(s, i, i+1); //assume even length.
	    }
	    return s.substring(lo, lo + maxLen);
	}

	private void extendPalindrome(String s, int j, int k) {
		while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
			j--;
			k++;
		}
		if (maxLen < k - j - 1) {
			lo = j + 1;
			maxLen = k - j - 1;
		}
	}
	
}
