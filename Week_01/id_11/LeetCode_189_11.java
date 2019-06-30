/**
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 * 链接：https://leetcode-cn.com/problems/rotate-array/
 */
class Solution {
    /**
     * 思考：
     * 这种反转办法虽然不是特别通用的解法，但是时间复杂度可能会比通用方法要高。
     * 
     */
    public void rotate(int[] nums, int k) {
        k%=nums.length;
        revert(nums,0,nums.length-1);
        revert(nums, 0, k-1);
        revert(nums,k, nums.length-1);
    }

    public int[] revert(int[] nums,int start,int end) {
        while (end > start) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
        return nums;
    }
}