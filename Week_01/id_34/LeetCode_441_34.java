/**
 * @author jinjw
 * @date 2019/6/22
 * @description 你总共有 n 枚硬币，你需要将它们摆成一个阶梯形状，第 k 行就必须正好有 k 枚硬币。
 * 给定一个数字 n，找出可形成完整阶梯行的总行数。
 * n 是一个非负整数，并且在32位有符号整型的范围内。
 */
public class LeetCode_441_34 {
    /**
     * 常规法
     */
    public int arrangeCoins(int n) {
        if (n == 1) return 1;
        int num = 0;
        for (int i = 1; i <= n; i++) {
            n = n - i;
            if (n < 0) break;
            num++;
        }
        return num;
    }

    /**
     * 二分法
     */
    public int arrangeCoins1(int n) {
        int i = 1, j = n, mid = 0;
        while (i <= j) {
            mid = i + (j - i) / 2;
            if ((double) (1 + mid) / 2 == (double) n / mid) {
                return mid;
            } else if ((double) (1 + mid) / 2 > (double) n / mid) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }
        return j;
    }

    /**
     * 数学公式
     */
    public int arrangeCoins2(int n) {
        return (int) ((-1 + Math.sqrt(1 + 8 * (long) n)) / 2);
    }
}
