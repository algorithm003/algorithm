# https://leetcode-cn.com/problems/number-of-islands/
# 典型的连通性问题.通过 DFS 记忆搜索可解决.

# 优化前:
class Solution1(object):
    def numIslands(self, grid):
        """
        :type grid: List[List[str]]
        :rtype: int
        """
        if not grid or not grid[0]:
            return 0

        count = 0
        m, n = len(grid), len(grid[0])
        visited = [[0] * n for i in range(m)]

        for i in range(m):
            for j in range(n):
                    if visited[i][j]==0 and grid[i][j]=='1':
                        count+=1
                        self.dfs(i, j, m, n, visited,grid)
        return count

    def dfs(self, i, j, m, n, visited,grid):
        if i < 0 or i >= m or j < 0 or j >= n:
            return

        if grid[i][j]=='0':
            return


        if visited[i][j] ==1:
            return

        if grid[i][j]=="1":
            visited[i][j] = 1

        self.dfs(i, j - 1, m, n, visited,grid)
        self.dfs(i, j + 1, m, n, visited,grid)
        self.dfs(i + 1, j, m, n, visited,grid)
        self.dfs(i - 1, j, m, n, visited,grid)

# 优化后:

class Solution2(object):
    def numIslands(self, grid):
        """
        :type grid: List[List[str]]
        :rtype: int
        """
        if not grid or not grid[0]:
            return 0

        count = 0

        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == '1':
                    count += 1
                    self.dfs(i, j, grid)
        return count

    def dfs(self, i, j, grid):
        if i < 0 or i >= len(grid) or j < 0 or j >= len(grid[0]):
            return

        if grid[i][j]=='#':
            return 

        grid[i][j] = '#'

        self.dfs(i, j - 1, grid)
        self.dfs(i, j + 1, grid)
        self.dfs(i + 1, j, grid)
        self.dfs(i - 1, j, grid)