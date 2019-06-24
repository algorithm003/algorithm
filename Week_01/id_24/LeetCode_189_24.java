package week1.rotateArray;

/**
 * Given an array, rotate the array to the right by k steps, where k is non-negative.
 */
public class Solution {
	public void rotate(int[] nums, int k) {
		k = k % nums.length;
		revers(nums, 0, nums.length - k - 1);
		revers(nums, nums.length - k, nums.length - 1);
		revers(nums, 0, nums.length - 1);
	}
	
	// Reveres array
	private void revers(int[] nums, int start, int end) {
		while (start < end) {
			int temp = nums[start];
			nums[start] = nums[end];
			nums[end] = temp;
			
			start++;
			end--;
		}
	}
	
	public static void main(String[] args) {
		Solution s = new Solution();
		s.rotate(new int[] {1,2,3,4,5,6,7}, 3);
		s.rotate(new int[] {-1,-100,3,99}, 2);
	}
}
