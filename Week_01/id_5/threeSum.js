/**
 * @param {number[]} nums
 * @return {number[][]}
 */

var threeSum = function (nums) {
  let res = []
  let size = nums.length
  nums.sort((a, b) => a - b)
  if (nums[0] > 0 || nums[size - 1] < 0) return []
  for (let i = 0; i < size - 2;) {
    let left = i + 1
    let right = size - 1
    do {
      if (nums[i] * nums[right] > 0) break
      let sum = nums[i] + nums[left] + nums[right]
      if (sum === 0) {
        res.push([nums[i], nums[left], nums[right]])
      }
      if (sum <= 0) {
        while (nums[left] === nums[++left]) {}
      } else {
        while (nums[right] === nums[--right]) {}
      }
    } while (left < right)
    while (nums[i] === nums[++i]) {}
  }
  return res
}