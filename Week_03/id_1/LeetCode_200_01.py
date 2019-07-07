# @Author：Kilien
# @lc app=leetcode id=200 lang=python3
# [200] Number of Islands
# https://leetcode.com/problems/number-of-islands/description/

'''
将一维延伸到二维，注意边界条件：上下左右
行列遍历，将‘1’的空格置为‘0’，count+1
以自身位置为起点向四周（上下左右）扩散，drill down 
'''
class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        if not grid: return 0
        
        count = 0
        row, col = len(grid), len(grid[0])
        for i in range(row):
            for j in range(col):
                if grid[i][j] == '1':
                    self.dfs(grid, i, j)
                    count += 1
        return count

    def dfs(self, grid, i, j):
        if i < 0 or j < 0 or i >= len(grid) or j >= len(grid[0]) or grid[i][j] != '1':
            return False
        grid[i][j] = '0'
        self.dfs(grid, i+1, j)
        self.dfs(grid, i-1, j)
        self.dfs(grid, i, j+1)
        self.dfs(grid, i, j-1)

