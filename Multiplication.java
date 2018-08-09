
public class Multiplication {
	
	public static void main(String[] args) {
		System.out.println(multiply(111111,222222222) == (111111*222222222));
	}

	private static int multiply(int m, int n) {
		int index = 0; 
		int sum = 0;
		for(int i=n; i>0;i>>=1 ) {
			if((i&1)==1) {
				sum += m<<index;
			}
			index++;
		}
		return sum;
	}
}
