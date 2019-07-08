package week2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @ author: Suhb
 * @ date: 2019/6/24 17:03
 * @ description: 哈希表：1. 两数之和
 */
public class LeetCode_1_035 {

    /*给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
    你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
    示例:
    给定 nums = [2, 7, 11, 15], target = 9
    因为 nums[0] + nums[1] = 2 + 7 = 9
    所以返回 [0, 1]*/
    private int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        Map<Integer, Integer> map = new HashMap<>();
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            int key = target - nums[i]; // 目标值 - 当前值 作为map的key值
            if (map.containsKey(key)) { // 如果map中存放key值,说明当前值与key值相加等于目标值
                return new int[]{map.get(key), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }

    public static void main(String[] args) {
        LeetCode_1_035 leetCode_1_035 = new LeetCode_1_035();
        int nums[] = new int[]{2, 7, 11, 15};
        int target = 9;
        int result[] = leetCode_1_035.twoSum(nums, target);
        System.out.println(Arrays.toString(result));
    }
}
