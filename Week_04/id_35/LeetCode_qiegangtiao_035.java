package week4;

import java.util.Arrays;

/**
 * @ author: Suhb
 * @ date: 2019/7/9 17:47
 * @ description:
 */
public class LeetCode_qiegangtiao_035 {
    private int getMaxValue(int[] nums, int n) {
        if (nums == null || nums.length == 0 || n < 1) {
            return 0;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 5;
        for (int i = 3; i <= n; i++) {
            int maxValue = Integer.MIN_VALUE;
            for (int j = 1; j <= i; j++) {
                if (i - j >= 0) {
                    maxValue = Math.max(maxValue, dp[i - j] + nums[j]);
                }
            }
            dp[i] = maxValue;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        LeetCode_qiegangtiao_035 leetCode_qiegangtiao_035 = new LeetCode_qiegangtiao_035();
        int[] nums = new int[]{0,1,5,8,9,10,17,17,20,24,30};
        int n = 5;
        int result = leetCode_qiegangtiao_035.getMaxValue(nums, n);
        System.out.println(result);
    }
}
