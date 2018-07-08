package LeetCode;

import java.util.Arrays;
import java.util.StringTokenizer;

public class CompareVersionNumbers {
	public static void main(String args[]) {
		
		System.out.println(compareVersion("1","1.1"));
	}
	 public static int compareVersion(String version1, String version2) {
		if(version1==null||version2==null) {
			return version1==null?-1:1;
		}
		if(version1.equals("")||version2.equals("")) {
			return version1.equals("")?-1:1;
		}
//		StringTokenizer tokenizer = new StringTokenizer(version1, ".");	
		String[] version1subs = version1.split("\\.");
		String[] version2subs = version2.split("\\.");
		
		int length2 = version2subs.length;
		int lenght1=version1subs.length;
		int shorterVersion = lenght1<length2?1:2;
		if(shorterVersion==1) {
			version1subs = Arrays.copyOf(version1subs, length2);
			for(int i=lenght1;i<length2;i++) {
				version1subs[i]="0";
			}
		}else {
			version2subs = Arrays.copyOf(version2subs, lenght1);
			for(int i=length2;i<lenght1;i++) {
				version2subs[i]="0";
			}
		}
		for(String i:version2subs) {
			System.out.println(i);
		}
		for(int i=0;i<version2subs.length;i++) {
			if(Integer.parseInt(version1subs[i])==Integer.parseInt(version2subs[i])){
				continue;
			}else if(Integer.parseInt(version1subs[i])>Integer.parseInt(version2subs[i])){
				return 1;
			}else {
				return-1;
			}
					
		}
		
		
		return 0;
	        
	    }
}
