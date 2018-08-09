import java.util.Random;

public class RandomizeArray {
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6,7,8,9,10};
		for(int i=0;i<10;i++) {
		randomize(arr);
		for(int num:arr) {
			System.out.print(num+" ");
		}
		System.out.println();
		}
	}
	public static void randomize(int[] arr) {
		
		for(int i=0;i<arr.length;i++) {
			int k = random(0,i);
			swap(arr, i,k);
		}
		
	}
	private static void swap(int[] arr, int i, int k) {

		int temp = arr[i];
		arr[i]=arr[k];
		arr[k]=temp;
	}
	private static int random(int min, int max) {
		Random rand = new Random();
		return min+rand.nextInt(max-min+1);
	}
}
