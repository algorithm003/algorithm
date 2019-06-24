/*
*
*   1. 两数之和
*
*   给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
*   你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
*
*   链接：https://leetcode-cn.com/problems/two-sum
*
*   学号：020
*
* */

public class LeetCode_1_TwoSum {


    //方法一：暴力解法，使用了双循环遍历计算出符合的答案。
    //时间复杂度： O(n²)，遍历计算过程中嵌套了两层循环。
    //空间复杂度： O(1)
    public int[] twoSum1(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            for (int j = i + 1 ; j < nums.length; j++) {
                if (cur + nums[j] == target) {
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{};
    }


    //方法二：使用 map 的特性，一次循环解决，速度更快。
    //时间复杂度： O(n), 遍历只用了一层 for 循环
    //空间复杂度： O(n)，利用了额外创建的存储n个元素的哈希表
    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int des = target - nums[i];
            if (map.containsKey(des)) {
                return new int[] { map.get(des), i };
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }

}
