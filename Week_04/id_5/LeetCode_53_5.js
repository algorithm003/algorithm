//给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
//
// 示例:
//
// 输入: [-2,1,-3,4,-1,2,1,-5,4],
//输出: 6
//解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
//
//
// 进阶:
//
// 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
//

/**
 * @param {number[]} nums
 * @return {number}
 */

// 动态规划算法：
// 时间复杂度：O(n)
// 空间复杂度：O(1)
// var maxSubArray = function(nums) {
//   let n = nums.length
//   if (!n) return 0
//   let [sum, res] = [nums[0], nums[0]]
//   for (let i = 1; i < n; i++) {
//     if (sum > 0) { // 如果前面的和大于0，加上我自己
//       sum += nums[i]
//     } else { // 如果前面的和小于0，从我自己开始
//       sum = nums[i]
//     }
//     // sum就等于从前面某一天到今天的增长
//     // 比较分组结果与前面求得的最大值
//     if (sum > res) {
//       res = sum
//     }
//   }
//   return res
// };


// 分治算法：
// 时间复杂度：O(n)
// 空间复杂度：O(1)
var maxSubArray = function(nums) {
  let n = nums.length
  if (!n) return 0
  let [sum, res] = [nums[0], nums[0]]
  merge(nums, 0, n - 1)
  return res

  function merge(nums, p, r) {
    if (p >= r) {
      // 如果前面的和大于0，加上我自己
      // 如果前面的和小于0，从我自己开始
      sum = sum > 0 && p > 0 ? sum + nums[p] : nums[p]
      // 比较分组结果与前面求得的最大值
      res = sum > res ? sum : res
      return
    }
    let q = Math.floor((p + r) / 2)
    merge(nums, p, q)
    merge(nums, q + 1, r)
  }
};

const nums = [-5, -6]
console.log(maxSubArray(nums));
