package algorithm.Week_04.id_50;

/**
 * Created by yu on 2019/7/14.
 * 最大子序和
 */
public class LeetCode_1046_050 {
    public int maxSubArray(int[] nums) {
        int ans = nums[0];
        int sum = 0;
        for (int num : nums) {
            if (sum > 0) {
                sum += num;
            } else {
                sum = num;
            }
            ans = Math.max(ans, sum);
        }
        return ans;
    }
}
