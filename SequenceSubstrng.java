import java.util.HashSet;
import java.util.Set;

public class SequenceSubstrng {

	public static void main(String[] args) {

		String s1 = "abapple";
		String s2 = "pineapples";
		Set<String> set1 = createSet(s1);
		Set<String> set2 = createSet(s2);
		String longestMatching = "";
		if(s2.length()>s1.length()) {
			longestMatching = findSequence(set1, set2);
		}else {
			longestMatching = findSequence(set2, set1);
		}
		System.out.println(longestMatching);
	}

	public static String findSequence(Set<String> set1, Set<String> set2) {
		String longetMatching = ""; 
		for(String eachSequence: set1) {
			if(set2.contains(eachSequence) && longetMatching.length()<eachSequence.length()) {
				longetMatching = eachSequence;
			}
		}
		return longetMatching;
	}

	public static Set<String> createSet(String s1){

		Set<String> set1 = new HashSet<>();
		for(int i=0; i<s1.length();i++) {
			for(int j=i+1; j<=s1.length();j++)
				set1.add(s1.substring(i, j));
		}
		return set1;
	}
}
