//
//  leetcode_189_29.swift
//  极客时间
//
//  Created by gavin hu on 2019/6/23.
//  Copyright © 2019 gavin hu. All rights reserved.
//

import Foundation


/*
 采用取反的方式
 */
class Solution {
    
    func rotate(_ nums: inout [Int], _ k: Int) {
        var rotateCount = k
        if  k > nums.count {
            rotateCount = k % nums.count
        }
        nums[0..<rotateCount].reverse()
        nums[rotateCount..<nums.count].reverse()
        nums.reverse()
    }
}

class Solution1 {
    
    /*每挪动一个元素 ，遍历一遍 时间复杂度是o(n) * o(k)*/
    func rotate(_ nums: inout [Int], _ k: Int) {
        var rotateCount = k
        if  k > nums.count {
            rotateCount = k % nums.count
        }
        while rotateCount > 0 {
            let lastNum = nums.last!
            for i in 0..<nums.count-1 {
                nums[nums.count - 1 - i] = nums[nums.count - 2 - i]
            }
            nums[0] = lastNum
            rotateCount -= 1
        }
    }
}

