//
//  leetcode_220_29.swift
//  极客时间
//
//  Created by gavin hu on 2019/6/30.
//  Copyright © 2019 gavin hu. All rights reserved.
//

import Foundation

func containsNearbyAlmostDuplicate(_ nums: [Int], _ k: Int, _ t: Int) -> Bool {
    var set: Set<Int> = []
    for (index, num) in nums.enumerated() {
        if t == 0 {
            if set.contains(num) {
                return true
            }
        } else {
            if set.contains(where: { abs($0 - num) <= t }) {
                return true
            }
        }
        set.insert(num)
        if index >= k {
            set.remove(nums[index - k])
        }
    }
    return false
}
