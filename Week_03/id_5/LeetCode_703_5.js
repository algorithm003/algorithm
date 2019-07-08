/**
 * @param {character[][]} grid
 * @return {number}
 */
var numIslands = function(grid) {
  let count = 0
  let n = grid.length
  if (!n) return 0
  let m = grid[0].length
  for (let i = 0; i < n; i++) {
    for (let j = 0; j < m; j++) {
      if (grid[i][j] === '1') {
        dfsIsland(grid, i, j)
        count++
      }
    }
  }
  return count

  function dfsIsland(grid, i, j) {
    if (i < 0 || j < 0 || i >= n || j >= m || grid[i][j] !== '1') return
    grid[i][j] = '0'
    dfsIsland(grid, i + 1, j)
    dfsIsland(grid,  i - 1, j)
    dfsIsland(grid, i, j + 1)
    dfsIsland(grid, i, j - 1)
  }
};