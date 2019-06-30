package week2.twoSum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, return <b>indices</b> of the two numbers such that they add up to a specific target.<br/>
 * You may assume that each input would have <b><i>exactly</i></b> one solution, and you may not use the same element twice.
 */
public class Solution {
    public int[] twoSum(int[] nums, int target) {
    	int[] result = new int[2];
    	
    	// Key is target's indicator, value is the index of nums
    	Map<Integer, Integer> temp = new HashMap<>();
    	for (int i = 0; i < nums.length; i++) {
    		// Hash of the key is same as target minus current num contains in map
    		// Current nums and the value of target minus current num in the map will be the result
			if(temp.containsKey(target - nums[i])) {
				result[0] = temp.get(target - nums[i]);
				result[1] = i;
			} else {
				temp.put(nums[i], i);
			}
		}
    	
        return result;
    }

	public static void main(String[] args) {
		Solution s = new Solution();
		
		System.out.println(Arrays.toString(s.twoSum(new int[] {2, 7, 11, 15}, 9)));
	}

}
