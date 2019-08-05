//
//  leetcode_53_29.swift
//  极客时间
//
//  Created by gavin hu on 2019/7/21.
//  Copyright © 2019 gavin hu. All rights reserved.
//

import Foundation

class Solution {
    func maxSubArray(_ nums: [Int]) -> Int {
        if nums.count == 0 {
            return 0
        }
        var curSum = nums[0]
        var maxSum = nums[0]
        for i in 1..<nums.count {
            if curSum + nums[i] > nums[i] {
                curSum += nums[i]
            }else {
                curSum = nums[i]
            }
            maxSum = max(maxSum, curSum)
        }
        return maxSum
    }
}
