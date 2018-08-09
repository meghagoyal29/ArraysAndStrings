import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Investment {
	public static void main(String[] args) {
		//System.out.println(findMax(6, "3 4 5 1 3 # 1"));
//		System.out.println(findMax(6, "3 4 5 1 3 # 1"));
	}
	
	static int test() {
		try {
			return 1;
		}finally {
			return 2;
		}
	}
	static long findMax(int n, String tree) {
		if(tree==null||tree.length()==0) {
			return 0L;
		}
		// sum of odd levels or sum of even levels will be max.
		//nth Level has 2^n nodes
		String[] array = tree.split(" ");
		// calculate number of levels from array.length
		int levels =(int)(Math.ceil((Math.log(array.length)/Math.log(2))));
		int oddLevelsSum = 0;
		int evenLevelssum = 0;
		int index = 0;
		for(int i=0; i<=levels;i++) {
			for(int j=0; j<Math.pow(2, i) && index< array.length ;j++) {
				if(i%2==0) {
					evenLevelssum = evenLevelssum + (array[index].equals("#")?0:Integer.parseInt(array[index]));
				}else {
					oddLevelsSum = oddLevelsSum + (array[index].equals("#")?0:Integer.parseInt(array[index]));
				}
				index++;
			}
			
		}
		return evenLevelssum>oddLevelsSum?evenLevelssum:oddLevelsSum;
	}
}
       