package LeetCode;

public class FindDuplicateNum {
	public static void main(String[] args) {
		int[] nums = {1,3,4,2,2};
		System.out.println(findDuplicate(nums ));
		
	}
	
	public static int findDuplicate(int[] nums) {
		 
	        int[] answer = new int[nums.length-1];
	        for(int j=0;j<answer.length;j++) {
	        	answer[j]=0;
	        }
	        for(int i=0;i<nums.length;i++) {
	        	answer[nums[i]-1]++;
	        	if(answer[nums[i]-1]>1)
	        		return nums[i];
	        }
			return -1;
	      }
	
	public int findDuplicateBest(int[] nums) {
		int low = 1, high = nums.length - 1;
	    while (low <= high) {
	        int mid = (int) (low + (high - low) * 0.5);
	        int cnt = 0;
	        for (int a : nums) {
	            if (a <= mid) ++cnt;
	        }
	        if (cnt <= mid) low = mid + 1;
	        else high = mid - 1;
	    }
	    return low;
	}
}


