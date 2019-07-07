/**
 * @author jinjw
 * @date 2019/7/7
 * @description 给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。
 * 一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。
 */
public class LeetCode_200_34 {
    boolean[][] visited = null;
    public int numIslands(char[][] grid) {
        if (grid.length == 0) return 0;
        int m = grid.length;
        int n = grid[0].length;
        int res = 0;
        visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    res++;
                    dfs(grid, i, j);
                }
            }
        }
        return res;
    }

    public void dfs(char[][] grid, int m, int n) {
        if (m >= 0 && m < grid.length && n >= 0 && n < grid[0].length) {
            if (!visited[m][n] && grid[m][n] == '1') {
                visited[m][n] = true;
                dfs(grid, m - 1, n);
                dfs(grid, m + 1, n);
                dfs(grid, m, n + 1);
                dfs(grid, m, n - 1);
            }
        }
    }
}
