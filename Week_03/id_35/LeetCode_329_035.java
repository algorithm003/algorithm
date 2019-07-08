package week3;

/**
 * @ author: Suhb
 * @ date: 2019/7/5 11:07
 * @ description: DFS + 记忆化：329. 矩阵中的最长递增路径
 */
public class LeetCode_329_035 {
    /*给定一个整数矩阵，找出最长递增路径的长度。
    对于每个单元格，你可以往上，下，左，右四个方向移动。 你不能在对角线方向上移动或移动到边界外（即不允许环绕）。
    示例 1:
        输入: nums =
                [
                [9,9,4],
                [6,6,8],
                [2,1,1]
                ]
        输出: 4
        解释: 最长递增路径为 [1, 2, 6, 9]。
    示例 2:
        输入: nums =
                [
                [3,4,5],
                [3,2,6],
                [2,2,1]
                ]
        输出: 4
        解释: 最长递增路径是 [3, 4, 5, 6]。注意不允许在对角线方向上移动。*/
    private static final int[][] forValue = new int[][]{{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
    private int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int length = matrix.length;
        int max = 0;
        int[][] cache = new int[length][matrix[0].length];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                max = Math.max(max, dfs(matrix, i, j, cache));  // 历遍每一个元素，获取最大的数
            }
        }
        return max;
    }

    private int dfs(int[][] matrix, int i, int j, int[][] cache) {
        if (cache[i][j] > 0) {
            return cache[i][j];
        }
        int max = 1;
        for (int[] value : forValue) {
            int x = i + value[0], y = j + value[1];
            if (x < 0 || y < 0 || x >= matrix.length || y >= matrix[x].length || matrix[x][y] <= matrix[i][j]) {
                continue;
            }
            max = Math.max(max, dfs(matrix, x, y, cache) + 1);
        }
        cache[i][j] = max;  // 记录已经历遍过的元素，避免重复搜索
        return max;
    }

    public static void main(String[] args) {
        LeetCode_329_035 leetCode_329_035 = new LeetCode_329_035();
        int[][] matrix = new int[][]{{7,7,5}, {2,4,6}, {8,2,0}};
        int result = leetCode_329_035.longestIncreasingPath(matrix);
        System.out.println(result);
    }
}
