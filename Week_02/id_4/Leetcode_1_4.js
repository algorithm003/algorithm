// 1. 两数之和 twoSum
// 题意解析: 在给定的 nums 中找到两个能组成 target 的元素，返回下标.
//      Tip: 使用两次循环的方法时记得不能重复使用数组的相同元素.


// 暴力解.
// 思路: 循环数组两次求解，注意避开相同下标元素.
// 复杂度分析:
//    时间: O(n^2). 循环数组两次.
//    空间: O(1). 无额外空间消耗.
// Leetcode 结果:
//    执行用时 : 160ms, 在所有 JavaScript 提交中击败了 61.99%的用户
//    内存消耗 : 34.6MB, 在所有 JavaScript 提交中击败 60.04%的用户
// 实现:
var twoSum = function(nums, target) {
  let len = nums.length;
  if (len < 2) return [];
  for (let i=0; i<len-1; i++) {
      for (let j=i+1; j<len; j++) {
          if (nums[i] === target - nums[j]) {
              return [i, j];
          }
      }
  }
  return [];
};

// Hashmap.
// 思路: 使用 Hashmap存储[目标值，当前位置]，循环 nums 尝试找到符合的目标值共同返回下标，找不到则返回空数组.
// 复杂度分析:
//    时间: O(n). 循环一次数组必定完成查找，最好 O(1),最坏 O(n).
//    空间: O(n). 借助 Hashmap 存储，最好 O(1),最坏 O(n).
// Leetcode 结果:
//    执行用时 : 80ms, 在所有 JavaScript 提交中击败了 95.80%的用户
//    内存消耗 : 35.4MB, 在所有 JavaScript 提交中击败 18.10%的用户
// 实现:
var twoSum = function(nums, target) {
  let map = new Map();
  for (let i=0, len=nums.length; i<len; i++) {
      let temp = nums[i];
      if (map.has(temp)) {
          return [map.get(temp), i]
      } 
      map.set(target-temp, i);
  }
  return [];
}