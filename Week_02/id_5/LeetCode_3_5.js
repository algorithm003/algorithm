//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
//
// 示例 1:
//
// 输入: "abcabcbb"
//输出: 3
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
//
//
// 示例 2:
//
// 输入: "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
//
//
// 示例 3:
//
// 输入: "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
//
//

/**
 * @param {string} s
 * @return {number}
 */

// 暴力解法 O(n*n*n)
var lengthOfLongestSubstring = function(s) {
  let res = 0
  let n = s.length
  for (let i = 0; i < n - 1; i++) {
    for (let j = i + 1; j <= n; j++) {
      if (uniqueString(s, i, j)) {
        res = Math.max(res, j - i)
      }
    }
  }
  return res
};
function uniqueString (s, start, end) {
  let set = new Set()
  for (let i = start; i < end; i++) {
    let ch = s.charCodeAt(i)
    if (set.has(ch)) {
      return false
    }
    set.add(ch)
  }
  return true
}

// 滑动窗口 Set集合 O(2n)
var lengthOfLongestSubstring = function(s) {
  let set = new Set()
  let [res, i, j, n] = [0, 0, 0, s.length]
  while (i < n && j < n) {
    if (!set.has(s.charCodeAt(j))) {
      // 窗口继续增大
      set.add(s.charCodeAt(j++))
      // 逐步比较增大的窗口值
      res = Math.max(res, j - i)
    } else {
      // 左边窗口逐渐向右靠拢，直到找到左边索引无法再移动
      // 即删除直到集合为空，再从重复的位置开始向右移动窗口
      set.delete(s.charCodeAt(i++))
    }
  }
  return res
}

// 滑动窗口 HashMap O(n)
var lengthOfLongestSubstring = function(s) {
  let map = new Map()
  let [res, i, j] = [0, 0, 0]
  const n = s.length
  while (i < n && j < n) {
    if (map.has(s.charCodeAt(j))) {
      // i直接跳到重复值的位置再滑动窗口
      // 省掉左边窗口逐渐缩小的过程
      i = Math.max(map.get(s.charCodeAt(j)), i)
    }
    // 从i开始到j结束窗口继续逐渐增大，并把不重复的字符加入map
    res = Math.max(res, j - i + 1)
    map.set(s.charCodeAt(j), ++j)
  }
  return res
}

// const s = 'pwwkew'
// console.log(lengthOfLongestSubstring(s));
