/*
 * @lc app=leetcode.cn id=26 lang=csharp
 *
 * [26] 删除排序数组中的重复项
 */
public class Solution {
    public int RemoveDuplicates(int[] nums)
    {
        if (nums.Length == 0) return 0;
        int index = 0;
        for (int i = 1; i < nums.Length; i++)
            if (nums[index] != nums[i])
                nums[++index] = nums[i];
        return index + 1;
    }
}

