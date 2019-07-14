/*
 * @lc app=leetcode.cn id=169 lang=java
 *
 * [169] 求众数
 */
class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}
