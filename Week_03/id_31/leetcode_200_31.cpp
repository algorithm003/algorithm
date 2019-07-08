#include <iostream>
#include <vector>

using namespace std;

/*
 * 给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。

示例 1:

输入:
11110
11010
11000
00000

输出: 1
示例 2:

输入:
11000
11000
00100
00011

输出: 3

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/number-of-islands
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

class Solution {
public:

    void dfs(vector<vector<char>>& grid,vector<vector<int>>& visit,int m,int n)
    {
        // 检查 m、n 的合法性
        if (m >= 0 && m < grid.size() && n >= 0 && n < grid[0].size()) {

            if (!visit[m][n] && grid[m][n] == '1') {
                // 先将当前土地标记为已经遍历过了
                visit[m][n] = true;
                // 然后给出新坐标往下遍历
                dfs(grid,visit, m-1, n);
                dfs(grid,visit, m+1, n);
                dfs(grid,visit, m, n+1);
                dfs(grid,visit, m, n-1);
            }
        }
    }

    int numIslands(vector<vector<char>>& grid) {

        vector<vector<int>> visit;

        if (grid.empty())
            return 0;

        int m = grid.size();
        int n = grid[0].size();
        visit.resize(m,vector<int>());

        for (int k = 0; k < m; ++k) {
            visit[k].resize(n,0);
        }

        int cnt = 0;
        // 遍历每一个节点，使用 foodfill 算法填充全的土地
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && !visit[i][j]) {
                    // 每一次 for 循环都是一次 fooldfill
                    // 一次 fooldfill 可以感染全部的相连的土地
                    // 那么下一次 for 村缓释遇到已经被感染过的土地了就不会进入这里面
                    // 进入这里面就代表发现了未被感染的土地，也就是新的岛屿
                    cnt++;
                    dfs(grid, visit,i, j);
                }
            }
        }
        return cnt;
    }
};

int main() {
    Solution mytest;
    vector<vector<char>> test1{{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
    cout << mytest.numIslands(test1) <<endl;

    vector<vector<char>> test2{{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}};
    cout << mytest.numIslands(test2) <<endl;

    return 0;
}