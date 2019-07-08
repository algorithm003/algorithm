//
//  leetcode_01_29.swift
//  极客时间
//
//  Created by gavin hu on 2019/6/30.
//  Copyright © 2019 gavin hu. All rights reserved.
//

import Foundation


class Solution {
    
    func twoSum(_ nums: [Int], _ target: Int) -> [Int] {
        var map:[Int:Int] = [Int:Int]()
        let res:[Int] = [Int]()
        for i in 0..<nums.count {
            if map[target - nums[i]] != nil {
                return [map[target - nums[i]]!,i]
            }
            map[nums[i]] = i
        }
        return res
    }
}
