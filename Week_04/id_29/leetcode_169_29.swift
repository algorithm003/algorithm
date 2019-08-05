//
//  leetcode_169_29.swift
//  极客时间
//
//  Created by gavin hu on 2019/7/21.
//  Copyright © 2019 gavin hu. All rights reserved.
//

import Foundation

/*
 
 方法一 使用 map 来做
 时间复杂度O(n)
 空间复杂度O(n)
 */

class Solution {
    func majorityElement(_ nums: [Int]) -> Int {
        var map:[Int:Int] = [Int:Int]()
        for num in nums {
            if map[num] == nil {
                map[num] = 1
            }else {
                map[num] = map[num]! + 1
            }
        }
        
        for key in map.keys {
            if map[key]! > nums.count / 2 {
                return key
            }
        }
        return 0
    }
}


/**
 先排序 再取中间值
 时间复杂度O(nlogn)
 空间复杂度O(n)
 */
class Solution1 {
    func majorityElement(_ nums: [Int]) -> Int {
        var newNums = nums
        newNums.sort()
        return newNums[nums.count/2]
    }
}


/**
 分治
 这里我们使用经典的分治算法递归求解，直到所有的子问题都是长度为 1 的数组。由于传输子数组需要额外的时间和空间，所以我们实际上只传输子区间的左右指针 lo 和 hi 表示相应区间的左右下标。长度为 1 的子数组中唯一的数显然是众数，直接返回即可。如果回溯后某区间的长度大于 1 ，我们必须将左右子区间的值合并。如果它们的众数相同，那么显然这一段区间的众数是它们相同的值。否则，我们需要比较两个众数在整个区间内出现的次数来决定该区间的众数。原问题的答案就是下标为 00 和 nn 之间的众数这一子问题
 */
class Solution2 {
    private func countInRange(_ nums: [Int] , _ num:Int ,_ lo:Int, _ hi:Int) -> Int {
        var count = 0
        for i in lo...hi {
            if nums[i] == num {
                count += 1
            }
        }
        return count
    }
    
    private func majorityElement(_ nums: [Int] , _ lo:Int, _ hi:Int) -> Int {
        if lo == hi {
            return nums[lo]
        }
        
        let mid = (hi - lo) / 2 + lo
        
        let left = majorityElement(nums, lo, mid)
        let rignt = majorityElement(nums, mid+1, hi)
        
        if left == rignt {
            return left
        }
        
        let leftCount = countInRange(nums,  left, lo, hi)
        let rightCount = countInRange(nums,  rignt, lo, hi)
        
        return leftCount > rightCount ? left : rignt
    }
    
    func majorityElement(_ nums: [Int]) -> Int {
        return majorityElement(nums, 0, nums.count - 1)
    }
}
