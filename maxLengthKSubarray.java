package LeetCode;

import java.util.HashMap;

public class maxLengthKSubarray {
	public static void main(String[] args) {
		int[] input = {1, -1, 5, -2, 3};
		//int[] input = {-2,-1,2,1};
		System.out.println(maxSubArrayLen(input,0,3));
	}
	 public static int maxSubArrayLen(int[] nums, int index, int k) {
		int sum = 0;
		int distance = 0;
		 HashMap<Integer,Integer> map= new HashMap();
		 map.put(0, -1);
		 for(int i= index; i<nums.length;i++) {
			 int value = nums[i]; 
			 sum+=value;
			 map.putIfAbsent(sum, i);
			 if(map.containsKey(sum-k)){
				 distance = Math.max(distance,i-map.get(sum-k));
				 System.out.println("sum: "+ sum+ " i: "+i+ " otherLoc "+ map.get(sum-k));
			 }
			 
		 }
		
		 return distance;
		 
	 }
}
