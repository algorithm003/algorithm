/**
 * @author jinjw
 * @date 2019/6/22
 * @description 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 */
public class LeetCode_50_34 {
    /**
     * @description 解法一常规解法
     */
    public double myPow1(double x, int n) {
        long a = n;
        if (a < 0) {
            x = 1 / x;
            n = -n;
        }
        double ans = 1;
        for (long i = 0; i < n; i++)
            ans = ans * x;
        return ans;
    }

    /**
     * @description 解法一递归
     */
    public double myPow2(double x, int n) {
        if (n == 0) return 1;
        if (n == 1) return x;
        if (n < 0) return myPow2(1 / x, -n);
        return x * myPow2(x, n - 1);
    }

    /**
     * @description 解法三 折半计算
     */
    public double myPow3(double x, int n) {
        if (n == 0) return 1;
        double res = 1;
        for (int i = n; i != 0; i = i / 2) {
            if (i % 2 != 0) res *= x;
            x *= x;
        }
        return n < 0 ? 1 / res : res;
    }
}
