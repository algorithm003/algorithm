//
//  leetcode_315_29.swift
//  极客时间
//
//  Created by gavin hu on 2019/6/30.
//  Copyright © 2019 gavin hu. All rights reserved.
//

import Foundation

class Solution {
    func countSmaller(_ nums: [Int]) -> [Int] {
        var res: [Int] = [Int](repeating: 0, count: nums.count)
        var vals = nums.sorted()
        for i in 0..<nums.count {
            let index = binarySearch(vals, nums[i])
            res[i] = index
            vals.remove(at: index)
        }
        return res
    }
    
    func binarySearch(_ nums: [Int], _ val: Int) -> Int {
        var start = 0
        var end = nums.count-1
        var mid = (end - start) / 2
        
        while start < end {
            if nums[mid] >= val {
                end = mid
            }else {
                start = mid + 1
            }
            mid = start + (end - start) / 2
        }
        
        return mid
    }
}
