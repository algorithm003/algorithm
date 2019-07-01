package week2;

/**
 * @ author: Suhb
 * @ date: 2019/6/26 21:49
 * @ description: DP：爬楼梯
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

    /**
     * 可以用 1 、 2 阶跑上第n阶，可以连续使用相同的爬台阶数
     * @param n
     * @return
     */
    private int climbStairs(int n) {
        if (n < 1) {
            return 0;
        }else if (n == 1) {
            return 1;
        }
        int[] dp = new int[n];
        dp[0] = 1;  // 第 1 阶，只有1种走法
        dp[1] = 2;  // 第 2 阶，可以走 2 个 一步 ，也可以走 2 个 两步
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];  // 到达当前这一步，可以走一阶也可以走两阶。那就成了分别到达前一阶、前二阶的不同走法的问题了
        }
        return dp[n - 1];
    }

    /**
     * 可以用 1 、 2、 3 阶跑上第n阶，但不能连续使用相同的爬台阶数
     * @param n
     * @return
     */
    private int climbStairs1Or3(int n) {
        if (n < 1) {
            return 0;
        } else if (n == 1 || n == 2) {
            return 1;
        } else if (n == 3) {
            return 3;
        }
        int coinsNum = 3;
        int[][] dp = new int[n][coinsNum + 1];

        dp[0][1] = 1;   // 第 1 阶， 1 阶到达的走法只有 1 种
        dp[1][2] = 1;   // 第 2 阶，2 阶到达的走法只有 1 种
        dp[2][1] = 1;   // 第 3 阶，1 阶到达的走法只有 1 种
        dp[2][2] = 1;   // 第 3 阶，2 阶到达的走法只有 1 种
        dp[2][3] = 1;   // 第 3 阶，3 阶到达的走法只有1 种
        for (int i = 3; i < n; i++) {
            dp[i][1] = dp[i - 1][2] + dp[i - 1][3]; // 如果到达第 n 阶是用了 1 阶到达的话，那前 1 阶只有是用 2、3 阶到达的
            dp[i][2] = dp[i - 2][1] + dp[i - 2][3]; // 如果到达第 n 阶是用了 2 阶到达的话，那前 2 阶只能是用 1、3 阶到达的
            dp[i][3] = dp[i - 3][1] + dp[i - 3][2]; // 如果到达第 n 阶是用了 3 阶到达的话，那前 3 阶只能是用 1、2 阶到达的
        }
        return dp[n - 1][1] + dp[n - 1][2] + dp[n - 1][3]; // 到达第 n 阶分别用 1、2、3 阶的不同走法之和
    }

    public static void main(String[] args) {
        LeetCode_70_035 leetCode_70_035 = new LeetCode_70_035();
        int n = 3;
        System.out.println(leetCode_70_035.climbStairs(n));
        n = 3;
        System.out.println(leetCode_70_035.climbStairs1Or3(6));
    }
}
