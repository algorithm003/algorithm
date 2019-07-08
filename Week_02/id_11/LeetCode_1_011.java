/*
 * @lc app=leetcode.cn id=1 lang=java
 *https://leetcode-cn.com/problems/two-sum/solution/liang-shu-zhi-he-by-leetcode-2/
 * [1] 两数之和
 */
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            int another = target - nums[i];
            if (hashMap.containsKey(another))
                return new int[] { i, hashMap.get(another) };
            hashMap.put(nums[i], i);
        }
        throw new IllegalArgumentException("no answer");
    }
    // 保持数组中的每个元素与其索引相互对应的最好方法是什么？哈希表。
}