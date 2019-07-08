// 242. 有效的字母异位词 isAnagram
// 题意解析: 判断两个字符串是否互为字母异位词(只考虑包含小写字母情况).
//    Tip: 字母异位词，即有等量相同字母但顺序不同的单词；


// 数组法.
// 思路: 用数组 025位存储 az 的数量，同时遍历字符串 s 和 t，前者加一后者减一，最终遍历结果数组是否全为0即可.
//    想法：增加数组空间使用，即使用0~123，免去每次字母ascii码转数组下标的过程，时间应该更快.
// 复杂度分析:
//    时间: O(n). 遍历一次足矣.
//    空间: O(1). 借助常量级别空间存储结果.
// Leetcode 结果:
//    执行用时 : 88ms, 在所有 JavaScript 提交中击败了 97.99%的用户
//    内存消耗 : 36.3MB, 在所有 JavaScript 提交中击败 73.03%的用户
// 实现:
var isAnagram = function(s, t) {
    let arr = Array.from({length: 26}, (v,i)=>0);
    if (s.length !== t.length) return false;
    for (let i=0, len=s.length; i<len; i++) {
        let [sNum, tNum] = [s[i].charCodeAt()-97, t[i].charCodeAt()-97];
        arr[sNum] += 1;
        arr[tNum] -= 1;
    }
    return arr.every(v=>v===0);
};


// 字符串排序法.
// 思路:重排序两个字符串，然后比较即可.
// 复杂度分析:
//    时间: O(nlogn). 主要耗时操作为排序，而字符串排序复杂度为nlogn.
//    空间: O(n). 字符串排序时借助了等同字符串长度 n 的空间.
// Leetcode 结果:
//    执行用时 : 160ms, 在所有 JavaScript 提交中击败了 52.01%的用户
//    内存消耗 : 38.2MB, 在所有 JavaScript 提交中击败 39.48%的用户
// 实现:
var isAnagram = function(s, t) {
    if (s.length !== t.length) return false;
    s = s.split('').sort().join('');
    t = t.split('').sort().join('');
    return s === t;
};


// 进阶对策：字符串包含 unicode 码
// 思路: 使用 Hashmap 存储[字符, s中出现次数-t中出现次数]. 最后检查 Hashmap 是否全部 value 为 0 即可.
// 复杂度分析:
//    时间: O(n). 也是遍历一次，过程类似数组解法.
//    空间: O(n). 最好 O(1), 最坏等同于字符串长度.
// Leetcode 结果:
//    执行用时 : 104ms, 在所有 JavaScript 提交中击败了 87.81%的用户
//    内存消耗 : 36.3MB, 在所有 JavaScript 提交中击败 73.03%的用户
// 实现:
var isAnagram = function(s, t) {
    if (s.length !== t.length) return false;
    
    let map = new Map();
    for (let i=0, len=s.length; i<len; i++) {
        if (!map.has(s[i])) map.set(s[i], 0); 
        map.set(s[i], map.get(s[i])+1);
        if (!map.has(t[i])) map.set(t[i], 0);
        map.set(t[i], map.get(t[i])-1);
    }
    
    for (let [key, value] of map.entries()) {
        if (value!==0) return false;
    }
    return true;
};