/*
 * @lc app=leetcode.cn id=200 lang=java
 *
 * [200] 岛屿数量
 */
class Solution {

    private static final int[][] directions = { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };

    class UnionFind {
        int count; // 岛屿数量
        // 将2d转化为1d
        int[] parent;
        // 对应节点的子节点数
        int[] rank;

        public UnionFind(char[][] grid) {
            count = 0;
            int m = grid.length;
            int n = grid[0].length;
            parent = new int[m * n];
            rank = new int[m * n];
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (grid[i][j] == '1') {
                        parent[i * n + j] = i * n + j;
                        // 将所有1都看成独立岛屿
                        ++count;
                    }
                    // 初始化排行
                    rank[i * n + j] = 0;
                }
            }
        }

        // 找到root节点
        public int find(int i) {
            if (parent[i] != i)
                parent[i] = find(parent[i]);
            return parent[i];
        }

        // 合并两个节点
        public void union(int x, int y) {
            int rootx = find(x);
            int rooty = find(y);
            if (rootx != rooty) {
                if (rank[rootx] > rank[rooty]) {
                    parent[rooty] = rootx;
                } else if (rank[rootx] < rank[rooty]) {
                    parent[rootx] = rooty;
                } else {
                    // x多一个子节点
                    parent[rooty] = rootx;
                    rank[rootx] += 1;
                }
                --count;
            }
        }

        public int getCount() {
            return count;
        }
    }

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;
        UnionFind unionFind = new UnionFind(grid);
        int coloum = grid[0].length;
        int row = grid.length;
        // 这里要注意横坐标和纵坐标的一一对应，容易弄反
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < coloum; j++) {
                if (grid[i][j] == '1') {
                    grid[i][j] = '0';
                    for (int k = 0; k < 4; k++) {
                        int x = i + directions[k][0];
                        int y = j + directions[k][1];
                        if (x < row &&x>=0&&y>=0&& y < coloum && grid[x][y] == '1') {
                            unionFind.union(i*coloum + j, x * coloum + y);
                        }
                    }
                }
            }
        }
        return unionFind.count;
    }
}
