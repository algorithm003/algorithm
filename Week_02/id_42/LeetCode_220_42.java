//给定一个整数数组，判断数组中是否有两个不同的索引 i 和 j，使得 nums [i] 和 nums [j] 的差
// 的绝对值最大为 t，并且 i 和 j 之间的差的绝对值最大为 ķ。
//
// 示例 1: 
//
// 输入: nums = [1,2,3,1], k = 3, t = 0
//输出: true 
//
// 示例 2: 
//
// 输入: nums = [1,0,1,1], k = 1, t = 2
//输出: true 
//
// 示例 3: 
//
// 输入: nums = [1,5,9,1,5,9], k = 2, t = 3
//输出: false 
//

import java.util.HashMap;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

class Solution220 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length < 2 || k < 1 || t < 0) {
            return false;
        }

        TreeSet<Long> window = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            long num = (long) nums[i];
            SortedSet<Long> set = window.subSet(num - t, true, num + t, true);
            if (!set.isEmpty()) return true;
            if (i >= k) {
                window.remove((long) nums[i - k]);
            }
            window.add(num);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1, 5, 4, 9, 1, 1, 5, 9};
        int k = 4, t = 3;

        Solution220 solution = new Solution220();
        boolean b = solution.containsNearbyAlmostDuplicate(nums, k, t);
        System.out.println(b);
    }
}