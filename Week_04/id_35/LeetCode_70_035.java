package week4;

/**
 * @ author: Suhb
 * @ date: 2019/7/12 10:20
 * @ description: 70. 爬楼梯
 */
public class LeetCode_70_035 {
    /*假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
    每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
    注意：给定 n 是一个正整数。
    示例 1：
        输入： 2
        输出： 2
        解释： 有两种方法可以爬到楼顶。
            1.  1 阶 + 1 阶
            2.  2 阶
    示例 2：
        输入： 3
        输出： 3
        解释： 有三种方法可以爬到楼顶。
            1.  1 阶 + 1 阶 + 1 阶
            2.  1 阶 + 2 阶
            3.  2 阶 + 1 阶*/
    private int climbStairs(int n) {
        if (n < 1) {
            return 0;
        } else if (n == 1 || n == 2) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        LeetCode_70_035 leetCode_70_035 = new LeetCode_70_035();
        int n = 1;
        int result = leetCode_70_035.climbStairs(4);
        System.out.println(result);
    }
}
