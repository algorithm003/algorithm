# hashmap

## Leetcode 刷题

### 1. 两数之和 twoSum
- 刷题进度:
    - [x] 暴力解.
    - [x] Hashmap.
- 难度: easy
- 题意解析: 在给定的 nums 中找到两个能组成 target 的元素，返回下标.
    - Tip: 使用两次循环的方法时记得**不能重复使用数组的相同元素**.
- 初始思路: 暴力解.
    - 思路: 循环数组两次求解，注意避开相同下标元素.
    - 复杂度分析:
        - 时间: O(n^2). 循环数组两次.
        - 空间: O(1). 无额外空间消耗.
    - Leetcode 结果:
        - 执行用时 : 160ms, 在所有 JavaScript 提交中击败了  61.99%的用户
        - 内存消耗 : 34.6MB, 在所有 JavaScript 提交中击败  60.04%的用户
    - 实现:
        ``` js
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
        ```
- 第二思路: Hashmap.
    - 思路: 使用 Hashmap存储[目标值，当前位置]，循环 nums 尝试找到符合的目标值共同返回下标，找不到则返回空数组.
    - 复杂度分析:
        - 时间: O(n). 循环一次数组必定完成查找，最好 O(1),最坏 O(n).
        - 空间: O(n). 借助 Hashmap 存储，最好 O(1),最坏 O(n).
    - Leetcode 结果:
        - 执行用时 : 80ms, 在所有 JavaScript 提交中击败了  95.80%的用户
        - 内存消耗 : 35.4MB, 在所有 JavaScript 提交中击败  18.10%的用户
    - 实现:
        ``` js
        let map = new Map();
        for (let i=0, len=nums.length; i<len; i++) {
            let temp = nums[i];
            if (map.has(temp)) {
                return [map.get(temp), i]
            } 
            map.set(target-temp, i);
        }
        return [];
        ```


### 242. 有效的字母异位词 isAnagram
- 刷题进度:
    - [x] 数组法.
    - [x] 字符串排序法.
    - [x] 进阶对策：字符串包含 unicode 码
- 难度: easy
- 题意解析: 判断两个字符串是否互为字母异位词(只考虑包含小写字母情况).
    - Tip: 字母异位词，即有等量相同字母但顺序不同的单词；
- 初始思路: 数组法.
    - 思路: 用数组 0~25位存储 a~z 的数量，同时遍历字符串 s 和 t，前者加一后者减一，最终遍历结果数组是否全为0即可.
        - 想法：增加数组空间使用，即使用0~123，免去每次字母ascii码转数组下标的过程，时间应该更快.
    - 复杂度分析:
        - 时间: O(n). 遍历一次足矣.
        - 空间: O(1). 借助常量级别空间存储结果.
    - Leetcode 结果:
        - 执行用时 : 88ms, 在所有 JavaScript 提交中击败了  97.99%的用户
        - 内存消耗 : 36.3MB, 在所有 JavaScript 提交中击败  73.03%的用户
    - 实现:
        ``` js
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
        ```
- 第二思路: 字符串排序法.
    - 思路:重排序两个字符串，然后比较即可.
    - 复杂度分析:
        - 时间: O(nlogn). 主要耗时操作为排序，而字符串排序复杂度为nlogn.
        - 空间: O(n). 字符串排序时借助了等同字符串长度 n 的空间.
    - Leetcode 结果:
        - 执行用时 : 160ms, 在所有 JavaScript 提交中击败了  52.01%的用户
        - 内存消耗 : 38.2MB, 在所有 JavaScript 提交中击败  39.48%的用户
    - 实现:
        ``` js
        var isAnagram = function(s, t) {
            if (s.length !== t.length) return false;
            s = s.split('').sort().join('');
            t = t.split('').sort().join('');
            return s === t;
        };
        ```
- 进阶对策：字符串包含 unicode 码
    - 思路: 使用 Hashmap 存储[字符, s中出现次数-t中出现次数]. 最后检查 Hashmap 是否全部 value 为 0 即可.
    - 复杂度分析:
        - 时间: O(n). 也是遍历一次，过程类似数组解法.
        - 空间: O(n). 最好 O(1), 最坏等同于字符串长度.
    - Leetcode 结果:
        - 执行用时 : 104ms, 在所有 JavaScript 提交中击败了  87.81%的用户
        - 内存消耗 : 36.3MB, 在所有 JavaScript 提交中击败  73.03%的用户
    - 实现:
        ``` js
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
        ```

### 3. 无重复字符的最长子串 lengthOfLongestSubstring
- 刷题进度:
    - [x] 字符串滑动窗口
    - [x] Hashmap 滑动窗口
- 难度: medium
- 题意解析: 找出某字符串中不含重复字符的"最长子串"的长度
- 初始思路: 
    - 思路: 用 max 存储最大长度，用 start不重复子串的存储开始位置，用 end 不断推进. 每次推进都判断是否出现重复，若出现则 start 等于**重复位置下标+1**.
    - 复杂度分析:
        - 时间: O(n^2). 遍历一次字符串复杂度为n,内部有indexOf查下标复杂度最好为1(全部字符重复)最坏为n(全部字符不重复)，故最好时间复杂度为 O(n),最坏为 O(n^2).
        - 空间: O(1). 中间值皆为常量级别.
    - Leetcode 结果:
        - 执行用时 : 108ms, 在所有 JavaScript 提交中击败了  96.51%的用户
        - 内存消耗 : 36.3MB, 在所有 JavaScript 提交中击败  98.47%的用户
    - 实现:
        ``` js
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
        ```
- 第二思路:
    - 思路: 使用 map 存储[字母，字母的数组下标]，方式类似初始思路.
    - 复杂度分析:
        - 时间: O(n). 遍历一次字符串复杂度为n, 无其他消耗.
        - 空间: O(n). 借助 HaspMap故空间最好为 O(1)最坏为 O(n).
    - Leetcode 结果:
        - 执行用时 : 108ms, 在所有 JavaScript 提交中击败了  96.51%的用户
        - 内存消耗 : 37.4MB, 在所有 JavaScript 提交中击败  90.71%的用户
    - 实现:
        ``` js
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
        ```