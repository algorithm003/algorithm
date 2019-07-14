/**
 * @param {number} n
 * @return {string[][]}
 */
var solveNQueens = function(n) {
  let result = new Array(n)
  let solutions = []
  cal8queen(0)
  return solutions

  function cal8queen(row) {
    if (row == n) { // 8行棋子都放置好了，输出结果
      solutions.push(printQueens(result))
      return // 退出递归
    }
    for (let column = 0; column < n; column++) { // 每一行都有8种放法
      if (isOk(row, column)) { // 有些放法不满足要求
        result[row] = column // 第 row 行的棋子放到了 column 列
        cal8queen(row + 1) // 考察下一行
      }
    }
  }
  function isOk(row, column) { // 判断 row 行 column 列放置是否合适
    let leftup = column - 1
    let rightup = column + 1
    for (let i = row - 1; i >= 0; i--) { // 逐行往上考察每一行
      if (result[i] == column) return false // 第 i 行的 column 列有棋子了吗？
      if (leftup >= 0) { // 考察左上对角线：第i行 leftup 列有棋子吗？
        if (result[i] == leftup) return false
      }
      if (rightup < n) { // 考察右上对角线：第 i 行 rightup 列有棋子吗？
        if (result[i] == rightup) return false
      }
      leftup--
      rightup++
    }
    return true
  }
  function printQueens(result) { // 打印出一个二维矩阵
    let formatResult = []
    for (let row = 0; row < n; row++) {
      formatResult[row] = ''
      for (let column = 0; column < n; column++) {
        if (result[row] == column) {
          formatResult[row] += 'Q'
        } else {
          formatResult[row] += '.'
        }
      }
    }
    return formatResult
  }
};
