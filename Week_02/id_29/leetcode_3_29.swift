//
//  leetcode_3_29.swift
//  极客时间
//
//  Created by gavin hu on 2019/6/30.
//  Copyright © 2019 gavin hu. All rights reserved.
//

import Foundation

class Solution {
    
    /*
     方法一 使用滑动窗口 跟 Map 来做
     
     其实就是一个队列,比如例题中的 abcabcbb，进入这个队列（窗口）为 abc 满足题目要求，当再进入 a，队列变成了 abca，这时候不满足要求。所以，我们要移动这个队列！
     
     如何移动？
     
     我们只要把队列的左边的元素移出就行了，直到满足题目要求！
     
     一直维持这样的队列，找出队列出现最长的长度时候，求出解！
     
     使用Map 的意思就是 移动的时候去判断Map里面是否出现过 现在的元素
     如果出现过 设置start 为
     
     
     */
    
    func lengthOfLongestSubstring(_ s: String) -> Int {
        var chars:[Character] = Array.init(s)
        var start = 0
        var end = 0
        var longest = 0
        var map:[Character:Int] = [Character:Int]()
        
        while end < chars.count {
            if map[chars[end]] != nil {
                    start = max(start, map[chars[end]]! + 1)
            }
            longest = max(longest, end - start + 1)
            map[chars[end]] = end
        }
        
        return longest
    }
}

class Solution2 {
    /*方法三
     采取两个指针 分别在字符串的最左边 跟最右边 ，两边往中间找
     */
    
    func lengthOfLongestSubstring(_ s: String) -> Int {
        var right = 1
        var left = 0
        var i = 0
        var result = 0
        if s.count > 0 {
            result = right - left
            let chars = Array(s.utf8)
            while right < chars.count {
                i = left
                while i < right {
                    if chars[i] == chars[right] {
                        left = i + 1
                        break
                    }
                    i = i + 1
                }
                result = max(result,right-left+1)
                right = right + 1
            }
        }
        return result
    }
}
