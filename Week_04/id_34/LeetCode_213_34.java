/**
 * @author jinjw
 * @date 2019/7/14
 * @description 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。
 * 这个地方所有的房屋都围成一圈，这意味着第一个房屋和最后一个房屋是紧挨着的。
 * 同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * <p>
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [2,3,2]
 * 输出: 3
 * 解释: 你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
 * 示例 2:
 * <p>
 * 输入: [1,2,3,1]
 * 输出: 4
 * 解释: 你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
 *      偷窃到的最高金额 = 1 + 3 = 4 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/house-robber-ii
 */
public class LeetCode_213_34 {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int len = nums.length;
        if (len == 1) return nums[0];
        if (len == 2) return Math.max(nums[0], nums[1]);
        return Math.max(findMax(nums, 0, len - 1), findMax(nums, 1, len));
    }

    public int findMax(int[] nums, int start, int end) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        int[] dp = new int[nums.length];
        for (int i = start; i < end; i++) {
            if (i - 2 >= 0) {
                sum = dp[i - 2] + nums[i];
            } else {
                sum = nums[i];
            }
            max = Math.max(sum, max);
            dp[i] = max;
        }
        return max;
    }
}
