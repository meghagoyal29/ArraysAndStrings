package LeetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
 */
class TwoSum {
	
    public int[] twoSum(int[] nums, int target) {
    	Arrays.sort(nums);
        for(int i=0; i<nums.length-1; i++){
            int diff = target-nums[i];
            for(int j=i+1;j<nums.length; j++){
                if(diff==nums[j]) {
                	int[] answer =  {i,j};
                    return answer;
                }
            }
        }
		return nums;
    }
    
    public int[] twoSumMap(int[] nums, int target) {
    	Map<Integer, Integer> placeMap = new HashMap<>();
        for(int i=0; i<nums.length; i++){
        	placeMap.put(nums[i], i);
        }
        for(int i=0; i<nums.length; i++){
        	int diff = target - nums[i];
        	if(placeMap.containsKey(diff) && placeMap.get(diff)!= i) {
            	int[] answer =  {i,placeMap.get(diff)};
                return answer;
        	}
        }
		return nums;
    }
    public int[] twoSumArr(int[] nums, int target) {
    	Map<Integer, Integer> placeMap = new HashMap<>();
        for(int i=0; i<nums.length; i++){
        	placeMap.put(nums[i], i);
        }
		return nums;
    }
    
}