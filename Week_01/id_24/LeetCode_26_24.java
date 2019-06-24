package week1.removeDuplicateFromSortedArray;

/**
 * Given a sorted array nums, remove the duplicates in-place such that each element appear only once and return the new length.
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 */
public class Solution {
	public int removeDuplicates(int[] nums) {
		// index is the first position of non duplicated value
		int index = 0;
		
		for (int num : nums) {
			// When index is 0 make index move one step first
			// Then the index position is position after the last non duplicated position 
			if(index == 0 || num > nums[index - 1]) {
				// Copy the next non duplicated num to index position and move index to next 1 step
				nums[index++] = num;
			}
		}
		
		return index;
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.removeDuplicates(new int[] {1,1,2}));
		System.out.println(s.removeDuplicates(new int[] {0,0,1,1,1,2,2,3,3,4}));
	}
}
