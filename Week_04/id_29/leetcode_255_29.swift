//
//  leetcode_255_29.swift
//  极客时间
//
//  Created by gavin hu on 2019/7/21.
//  Copyright © 2019 gavin hu. All rights reserved.
//

import Foundation

class Solution {
    func findContentChildren(_ g: [Int], _ s: [Int]) -> Int {
        let g1 = g.sorted()
        let s1 = s.sorted()
        
        var gi = 0
        var si = 0
        
        var count = 0
        
        while gi < g1.count  && si < s1.count {
            if s1[si] >= g1[gi] {
                count += 1
                gi += 1
                si += 1
            }else {
                si += 1
            }
        }
        return count
    }
}
