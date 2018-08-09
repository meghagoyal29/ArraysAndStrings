
public class Equillibrium {

	public static void main(String[] args) {

		int[] arr = new int[11];
		int[] sumfwd = new int[11];
		int[] sumbkwd = new int[11];

		for(int i = 0; i<11; i++) {
			arr[i] = 2;
		}
		for(int i = 1; i<11; i++) {
			sumfwd[i] = sumfwd[i-1]+arr[i-1];
		}
		for(int i = 9; i>=0; i--) {
			sumbkwd[i] = sumbkwd[i+1]+arr[i+1];
		}
		for(int i = 1; i<11; i++) {

			if(sumfwd[i] == sumbkwd[i]) {
				System.out.println(i);
				break;
			}
		}

	}
}
