//编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target。该矩阵具有以下特性：
//
//
// 每行的元素从左到右升序排列。
// 每列的元素从上到下升序排列。
//
//
// 示例:
//
// 现有矩阵 matrix 如下：
//
// [
//  [1,   4,  7, 11, 15],
//  [2,   5,  8, 12, 19],
//  [3,   6,  9, 16, 22],
//  [10, 13, 14, 17, 24],
//  [18, 21, 23, 26, 30]
//]
//
//
// 给定 target = 5，返回 true。
//
// 给定 target = 20，返回 false。
//

/**
 * @param {number[][]} matrix
 * @param {number} target
 * @return {boolean}
 */

// 分治算法：
// n表示列数，m表示行数
// 时间复杂度：O(n*logn)，在列里面对行进行二分查找
// 空间复杂度：O(logn)，递归由树（因为是有序数组，每走一步可以去掉一半选项）的高度决定
// var searchMatrix = function(matrix, target) {
//   if (!matrix || !matrix.length) return false
//   return search(0, 0, matrix[0].length - 1, matrix.length - 1)
//
//   function search(left, up, right, down) {
//     if (left > right || up > down) {
//       return false
//     } else if (target < matrix[up][left] || target > matrix[down][right]) {
//       return false
//     }
//     let mid = Math.floor(left + (right - left) / 2)
//     let row = up
//     while (row <= down && matrix[row][mid] <= target) {
//       if (matrix[row][mid] === target) {
//         return true
//       }
//       row++
//     }
//     return search(left, row, mid - 1, down) || search(mid + 1, up, right, row - 1)
//   }
// };

// 时间复杂度：O(n + m)，循环的次数不会超过n列 + m行
// 空间复杂度：O(1)
var searchMatrix = function(matrix, target) {
  let row = matrix.length - 1
  let col = 0
  while (row >= 0 && col < matrix[0].length)  {
    if (matrix[row][col] > target) {
      row--
    } else if (matrix[row][col] < target) {
      col++
    } else {
      return true
    }
  }
  return false
}

const matrix = [
  [1,   4,  7, 11, 15],
  [2,   5,  8, 12, 19],
  [3,   6,  9, 16, 22],
  [10, 13, 14, 17, 24],
  [18, 21, 23, 26, 30]
]
const target = 20
console.log(searchMatrix(matrix, target));
