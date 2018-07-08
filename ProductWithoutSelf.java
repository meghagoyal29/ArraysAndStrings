package LeetCode;

public class ProductWithoutSelf {
public static void main(String[] args) {
	int[] input = {1,2,3,4};
	int[] answer = productExceptSelf(input);
	for(int i : answer) {
		System.out.print(i+" ");
	}
	System.out.println();
	
}
public static int[] productExceptSelf(int[] nums) {
	int[] answer = new int[nums.length];
	int runningProduct = 1;
	int[] mulsRight = new int[nums.length];
	mulsRight[nums.length-1] = nums[nums.length-1];
	for(int j = nums.length-2; j>=0; j--) {
		mulsRight[j] = mulsRight[j+1]*nums[j];
	}
	
	for(int k = 0;k<nums.length-1;k++) {
	answer[k] = runningProduct*mulsRight[k+1];
	runningProduct*=nums[k];
       }
	answer[nums.length-1]=runningProduct;
	return answer;
}
}
