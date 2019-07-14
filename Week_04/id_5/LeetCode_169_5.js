//给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
//
// 你可以假设数组是非空的，并且给定的数组总是存在众数。
//
// 示例 1:
//
// 输入: [3,2,3]
//输出: 3
//
// 示例 2:
//
// 输入: [2,2,1,1,1,2,2]
//输出: 2
//
//

/**
 * @param {number[]} nums
 * @return {number}
 */

// 分治算法
// 时间复杂度：O(n)，遍历了每个元素
// 空间复杂度：最坏是O(n)，最好是O(1)

var majorityElement = function(nums) {
  let p = 0
  let r = nums.length - 1
  let hash = new Map()
  merge(nums, p, r)
  if (!hash.size) return nums[0]
  for (let index of hash.keys()) {
    let result = hash.get(index)
    if (result > (nums.length / 2)) return index
  }

  function merge(nums, p, r) {
    if (p >= r) {
      let num = hash.get(nums[p]) ? hash.get(nums[p]) : 0
      hash.set(nums[p], num + 1)
      return
    }
    let q = Math.floor((p + r) / 2)
    merge(nums, p, q)
    merge(nums, q + 1, r)
  }
};


// 散列表解法
// var majorityElement = function(nums) {
//   let hash = {}
//   for (let i of nums) {
//     hash[i] = hash[i] ? hash[i] + 1 : 1
//   }
//   for (let i in hash) {
//     if (hash[i] >= (nums.length / 2)) return i
//   }
// };


const nums = [6,5,5]
console.log(majorityElement(nums));
