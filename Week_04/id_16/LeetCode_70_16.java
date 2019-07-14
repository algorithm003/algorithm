public class LeetCode_70_16 {
    public int climbStairs(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }

        int[] solution = new int[n+1];
        solution[0] = 1;
        solution[1] = 1;
        for (int i = 2; i <= n; i ++) {
            solution[i] = solution[i-1] + solution[i-2];
        }

        return solution[n];
    }
}
