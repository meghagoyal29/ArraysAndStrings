import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Median {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		List<Integer> a = new ArrayList<Integer>();
		for(int a_i=0; a_i < n; a_i++){
			a.add(in.nextInt());
			System.out.println(claculateMedian(a));
		}
	}

	private static double claculateMedian(List<Integer> a) {
		Collections.sort(a);
		int index = a.size()/2;
		double answer = 0.0;
		if(a.size()%2 == 0) {
			answer = ((double)a.get(index-1)+(double)a.get((index)))/2;
		}
		else answer = a.get((index));

		return answer;

	}
}

