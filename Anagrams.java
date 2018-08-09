import java.util.*;

/**
 * @author megha
 *
 *https://www.hackerrank.com/challenges/ctci-making-anagrams
 */
public class Anagrams {
	public static int numberNeeded(String first, String second) {
		Map<Character, Integer> firstMap, secondMap;
		int number = 0;
		firstMap = createMapFromString(first);
		secondMap = createMapFromString(second);
		for(Character eachChar : firstMap.keySet()){
			if(secondMap.containsKey(eachChar)){
				number = number + Math.abs(secondMap.get(eachChar)- firstMap.get(eachChar));
				secondMap.remove(eachChar);
			}else {
				number = number+firstMap.get(eachChar);
			}
		}
		for(Character eachChar : secondMap.keySet()){
			number = number + Math.abs(secondMap.get(eachChar));
		}
		return number;
	}
	private static Map<Character, Integer> createMapFromString(String str)
	{
		Map<Character, Integer>map = new HashMap<Character, Integer>(); 

		for(char eachchar : str.toCharArray()){
			if(map.containsKey(eachchar)){
				map.put(eachchar, map.get(eachchar)+1);
			}else{
				map.put(eachchar, 1);
			}
		} 
		return map;
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String a = in.next();
		String b = in.next();
		System.out.println(numberNeeded(a, b));
	}
}
