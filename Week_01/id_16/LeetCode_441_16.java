public class LeetCode441 {
    public int arrangeCoins(int n) {
        if (n <= 1) {
            return n;
        }

        int row = 1;

        while (n >= row) {
            n = n - row;
            row ++;
        }

        return -- row;
    }
}
