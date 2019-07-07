public class LeetCode_200_42 {
    public int numIslands(char[][] grid) {
        int ret = 0;
        // 参数校验
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        // 元素默认值是false
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                // 如果此位置没有被访问过，并且此位置是岛，广度优先遍历
                if (!visited[i][j] && grid[i][j] == 1) {
                    ret++;
                    bfs(grid, visited, i, j);
                }
            }
        }
        for (boolean[] a : visited)
            for (boolean b : a)
                System.out.println(b ? 1 : 0);

        return ret;
    }

    /**
     * 广度优先搜索
     *
     * @param grid    网格
     * @param visited 访问标记矩阵
     * @param row     横坐标
     * @param col     纵坐标
     */
    private void bfs(char[][] grid, boolean[][] visited, int row, int col) {

        if (row >= 0 && row < grid.length // 行合法
                && col >= 0 && col < grid[0].length // 列合法
                && !visited[row][col] // 没有访问过
                && grid[row][col] == 1) { // 是岛上陆地

            // 标记此位置已经访问
            visited[row][col] = true;

            // 上
            bfs(grid, visited, row - 1, col);
            // 右
            bfs(grid, visited, row, col + 1);
            // 下
            bfs(grid, visited, row + 1, col);
            // 左
            bfs(grid, visited, row, col - 1);

        }

    }
