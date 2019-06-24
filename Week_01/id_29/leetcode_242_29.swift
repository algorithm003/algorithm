//
//  leetcode_242_29.swift
//  极客时间
//
//  Created by gavin hu on 2019/6/23.
//  Copyright © 2019 gavin hu. All rights reserved.
//

import Foundation

class Solution {
    
    /*
     方法一：
     #1 将字符串S 中的字符作为key 出现的次数作为value 存储到map 这个数据结构中
     #2 将字符串T 中的字符作为key 遍历是否在map 中有 ，如果有的话 所对应的value - 1
     #3 遍历这个map 是否存在value 不为1 的情况 如果存在  返回false
     */
    
    func isAnagram(_ s: String, _ t: String) -> Bool {
        let char_s:[Character] = Array.init(s)
        let char_t:[Character] = Array.init(t)
        
        var map:[Character:Int] = [Character:Int]()
        
        for char in char_s {
            let count = (map[char] ?? 0) + 1
            map[char] = count
        }
        
        for char in char_t {
            let count = (map[char] ?? 0) - 1
            map[char] = count
        }
        
        for val in map.values {
            if val != 0 {
                return false
            }
        }
        
        return true
    }
}

class Solution_1 {
    
    /*
     方法同 方法一 但是可以减少一次for循环
     */
    
    func isAnagram(_ s: String, _ t: String) -> Bool {
        let char_s:[Character] = Array.init(s)
        let char_t:[Character] = Array.init(t)
        
        if char_s.count != char_t.count {
            return false
        }
        
        var map:[Character:Int] = [Character:Int]()
        
        for i in 0..<char_s.count {
            var count = (map[char_s[i]] ?? 0) + 1
            map[char_s[i]] = count
            count = (map[char_t[i]] ?? 0) - 1
            map[char_t[i]] = count
        }

        for val in map.values {
            if val != 0 {
                return false
            }
        }
        
        return true
    }
}
