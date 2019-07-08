package week3;

/**
 * @ author: Suhb
 * @ date: 2019/7/2 15:06
 * @ description: 53. 最大子序和
 */
public class LeetCode_53_035 {
    /*给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
    示例:
        输入: [-2,1,-3,4,-1,2,1,-5,4],
        输出: 6
        解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
    进阶:
        如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。*/
    private int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        }
        int sum = 0;    // 一段一段的相加总和
        int maxValue = Integer.MIN_VALUE;   // 相加总和的最大值
        for (int num : nums) {
            sum = sum > 0 ? sum + num : num;    // 如果当前的相加总数大于0，那可以继续加起，反之，就以当前值为相加总和继续
            maxValue = Math.max(maxValue, sum); // 判断相加总和的最大值
        }
        return maxValue;
    }

    public static void main(String[] args) {
        LeetCode_53_035 leetCode_53_035 = new LeetCode_53_035();
        int[] nums = new int[]{1, 2};
        int result = leetCode_53_035.maxSubArray(nums);
        System.out.println(result);
    }
}
