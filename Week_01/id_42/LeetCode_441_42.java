package src;

public class Solution {
    public int arrangeCoins(int n) {
        int i = 1;
        int sub = n;
        int res = 0;
        for (i = 1; i <= n; i++) {
            sub = sub - i;
            if (sub - (i + 1) < 0) {
                res = i;
                break;
            }
            if (sub - (i + 1) == 0) {
                res = i + 1;
                break;
            }
            if (sub - (i + 1) > 0) {
                continue;
            }
        }
        return res;
    }

    public static void main(String[] args) {

    }
}


// 代码可以进一步简化！