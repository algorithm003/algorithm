// 3. 无重复字符的最长子串 lengthOfLongestSubstring
// 题意解析: 找出某字符串中不含重复字符的"最长子串"的长度

// 字符串滑动窗口
// 思路: 用 max 存储最大长度，用 start不重复子串的存储开始位置，用 end 不断推进. 每次推进都判断是否出现重复，若出现则 start 等于重复位置下标+1.
// 复杂度分析:
//    时间: O(n^2). 遍历一次字符串复杂度为n,内部有indexOf查下标复杂度最好为1(全部字符重复)最坏为n(全部字符不重复)，故最好时间复杂度为 O(n),最坏为 O(n^2).
//    空间: O(1). 中间值皆为常量级别.
// Leetcode 结果:
//    执行用时 : 108ms, 在所有 JavaScript 提交中击败了 96.51%的用户
//    内存消耗 : 36.3MB, 在所有 JavaScript 提交中击败 98.47%的用户
// 实现:
var lengthOfLongestSubstring = function(s) {
    let len = s.length;
    if (len < 2) return len;
    let max = 1;
    for (let start=0, end=1; end<len; end++) {
        // 在start之后检索当前字符：
        //   - 当有重复字符出现，且该重复字符小于 end 时， 将 start赋值为重复位置下标+1
        //   - 当没有重复字符串出现时，计算最大子串长度
        let repeatIndex = s.indexOf(s[end], start);     // 从 start 开始，避免了 start 回退
        if (repeatIndex >= 0 && repeatIndex < end) {
            start = repeatIndex+1;
        } else {
            max = Math.max(max, end-start+1);
        }
    }
    return max;
};

// Hashmap 滑动窗口
// 思路: 使用 map 存储[字母，字母的数组下标]，方式类似初始思路.
// 复杂度分析:
//    时间: O(n). 遍历一次字符串复杂度为n, 无其他消耗.
//    空间: O(n). 借助 HaspMap故空间最好为 O(1)最坏为 O(n).
// Leetcode 结果:
//    执行用时 : 108ms, 在所有 JavaScript 提交中击败了 96.51%的用户
//    内存消耗 : 37.4MB, 在所有 JavaScript 提交中击败 90.71%的用户
// 实现:
var lengthOfLongestSubstring = function(s) {
    let map = new Map();
    let max = 0;
    for (let start=0, end=0, len=s.length; end<len; end++) {
        if (map.has(s[end])) {
            start = Math.max(map.get(s[end])+1, start);     // 用 Math.max 避免 start 回退
        } 
        map.set(s[end], end);
        max = Math.max(max, end-start+1);
    }
    return max;
};