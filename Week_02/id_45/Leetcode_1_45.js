/**
  *   @answer jhwong
  * 
  *   1. 两数之和
  *   给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
  *
  *    给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
  *
  *    你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
  *
  *    示例:
  *
  *    给定 nums = [2, 7, 11, 15], target = 9
  *
  *    因为 nums[0] + nums[1] = 2 + 7 = 9
  *    所以返回 [0, 1]
  *
  *
  *    学号：045
  *
  * */


/**
 * 暴力法，嵌套循环
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
const twoSum1 = (nums, target) => {
    for(let i = 0; i < nums.length; i++)
        for(let j = i + 1; j <= nums.length; j++)
            if(nums[i] + nums[j] == target) return [i,j]
}

/**
 * 基于hash表的方法
 * step 1： 创建一个hashmap
 * step 2： 遍历 nums 根据target减去遍历的元素的差作为hashmap的key
 * step 3： 如果hashmap存在这个差值，则表示找到了对应的两个值，如果不存在则将当前的 (nums[i],i) 存入 hashmap 中
 * step 4： 遍历直到找到为止，如果不存在则返回null
 * 
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
const twoSum2 = (nums, target) =>  nums.reduce((pre,next,i) => pre[target - next] != null ? (pre.res = [pre[target - next],i], pre) : (pre[next] = i, pre) , {}).res