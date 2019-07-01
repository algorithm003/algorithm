//
//  leetcode_242_29.swift
//  极客时间
//
//  Created by gavin hu on 2019/6/30.
//  Copyright © 2019 gavin hu. All rights reserved.
//

import Foundation

class Solution {
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
