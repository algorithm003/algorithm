class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        if not grid:
            return 0

        def dfs(grid, i, j):
            if i < 0 or j < 0 or i > len(grid) - 1 or j > len(grid[0]) -1  or grid[i][j] != "1":
                return
            grid[i][j] = "#"
            dfs(grid, i+1, j)
            dfs(grid, i-1, j)
            dfs(grid, i, j+1)
            dfs(grid, i, j-1)

        count = 0
        for i in range(len(grid)):
            for j in range(len(grid[i])):
                if grid[i][j] == "1":
                    count += 1
                dfs(grid, i, j)

        return count