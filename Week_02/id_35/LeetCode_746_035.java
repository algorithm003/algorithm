package week2;

/**
 * @ author: Suhb
 * @ date: 2019/6/27 14:52
 * @ description: DP：746. 使用最小花费爬楼梯
 */
public class LeetCode_746_035 {
    /*数组的每个索引做为一个阶梯，第 i个阶梯对应着一个非负数的体力花费值 cost[i](索引从0开始)。
    每当你爬上一个阶梯你都要花费对应的体力花费值，然后你可以选择继续爬一个阶梯或者爬两个阶梯。
    您需要找到达到楼层顶部的最低花费。在开始时，你可以选择从索引为 0 或 1 的元素作为初始阶梯。
    示例 1:
        输入: cost = [10, 15, 20]
        输出: 15
        解释: 最低花费是从cost[1]开始，然后走两步即可到阶梯顶，一共花费15。
    示例 2:
        输入: cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
        输出: 6
        解释: 最低花费方式是从cost[0]开始，逐个经过那些1，跳过cost[3]，一共花费6。
    注意：
        cost 的长度将会在 [2, 1000]。
        每一个 cost[i] 将会是一个Integer类型，范围为 [0, 999]。*/
    private int minCostClimbingStairs(int[] cost) {
        if (cost.length == 2) { // 因为注明 length 会在 2 ~ 1000
            return Math.min(cost[0], cost[1]);  // 因为走了当前的这一阶梯，还可以继续向前一步或两步；所以如果只有两个元素，那无论走哪个，下一次就都可以到达顶楼，所以，就成了判断两个值的最小即可
        }
        int length = cost.length;
        int[] dp = new int[length];
        dp[0] = cost[0];    // 0 的元素作为初始阶梯花费值
        dp[1] = cost[1];    // 1 的元素作为初始阶梯花费值
        for (int i = 2; i < length; i++) {
             /*要上到顶楼，只能从顶楼的前一步或者前两步上去
             * 所以要上到顶楼的最小花费问题，就成了，前一步或者前两步的最小花费问题了
             * 最后还得加上当前的花费，因为是从这一层上顶楼的*/
            dp[i] = Math.min(dp[i - 1], dp[i - 2]) + cost[i];
        }
        return Math.min(dp[length - 1], dp[length - 2]);    // 求到达数据最后两个元素的最小花费即是上到顶楼的最小花费
    }

    public static void main(String[] args) {
        LeetCode_746_035 leetCode_746_035 = new LeetCode_746_035();
        int[] cost = new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        int result = leetCode_746_035.minCostClimbingStairs(cost);
        System.out.println(result);
    }
}
