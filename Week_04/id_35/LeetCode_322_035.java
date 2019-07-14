package week4;

/**
 * @ author: Suhb
 * @ date: 2019/7/9 14:35
 * @ description: 322. 零钱兑换
 */
public class LeetCode_322_035 {
    /*给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
    示例 1:
        输入: coins = [1, 2, 5], amount = 11
        输出: 3
        解释: 11 = 5 + 5 + 1
    示例 2:
        输入: coins = [2], amount = 3
        输出: -1
    说明:
        你可以认为每种硬币的数量是无限的。*/

    /**
     * DP
     * @param coins
     * @param amount
     * @return
     */
    private int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0 || amount < 1) {
            return 0;
        }
        int[] dp = new int[amount + 1];
        for (int money : coins) {
            if (money <= amount) {
                dp[money] = 1;
            }
        }
        for (int i = 1; i <= amount; i++) {
            int minValue = -1;
            for (int money : coins) {
                if (i >= money && dp[i - money] != -1) {
                    minValue = minValue == -1 ? dp[i - money] + 1 : Math.min(minValue, dp[i - money] + 1);
                }
            }
            dp[i] = minValue;
        }
        return dp[amount];
    }

    /**
     * 该方法超出时间限制
     * @param coins
     * @param amount
     * @return
     */
    private int coinChange2(int[] coins, int amount) {
        /*执行结果：
        解答错误
                显示详情
        输入: [1] 0
        输出： -1
        预期结果：0
        这样的一个结果，我就懵了，不是说“如果没有任何一种硬币组合能组成总金额，返回 -1”。。。*/
        /*if (coins == null || coins.length == 0 || amount < 0) {
            return -1;
        }*/
        if (coins == null || coins.length == 0 || amount < 0) {
            return 0;
        }
        int result = getMaxValue(coins, 0, amount, 0);
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    /**
     * 该方法超出时间限制
     * @param coins
     * @param money
     * @param amount
     * @param totals
     * @return
     */
    private int getMaxValue(int[] coins, double money, double amount, int totals) {
        if (money > amount) {
            return Integer.MAX_VALUE;
        } else if (money == amount) {
            return totals;
        }
        int minValue = Integer.MAX_VALUE;
        for (int i : coins) {
            int value = getMaxValue(coins, money + i, amount, totals + 1);
            minValue = Math.min(minValue, value);
        }
        return minValue;
    }

    public static void main(String[] args) {
        LeetCode_322_035 leetCode_322_035 = new LeetCode_322_035();
        int[] coins = new int[]{186,419,83,408};
        int amount = 6249;
        int result = leetCode_322_035.coinChange(coins, amount);
        System.out.println(result);
    }
}
