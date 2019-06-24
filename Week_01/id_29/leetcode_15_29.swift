//
//  leetcode_15_29.swift
//  极客时间
//
//  Created by gavin hu on 2019/6/23.
//  Copyright © 2019 gavin hu. All rights reserved.
//

import Foundation

class Solution {
    /*
     方法一 暴力法  时间复杂度O(n^3)
     */
    func threeSum(_ nums: [Int]) -> [[Int]] {
        var result = [[Int]]()
        for i in 0..<nums.count-2 {
            for j in i+1..<nums.count-1 {
                for m in j+1..<nums.count {
                    if nums[i] + nums[j] + nums[m] == 0 {
                        let num = [nums[i],nums[j],nums[m]].sorted()
                        if !result.contains(num){
                            result.append(num)
                        }
                    }
                }
            }
        }
        return result
    }
}


class Solution_1 {
    /*
      使用两数之和来做 ，三数之和为0。那么遍历这个数组 看存不存在两数之和为这个数的相反数 时间复杂度0(n^2)*o(3*log(3)) 空间复杂度0(n)
     */
    func threeSum(_ nums: [Int]) -> [[Int]] {
        if nums.count < 3 {
            return [[Int]]()
        }
        
        var map:[Int:Int] =  [Int:Int]()
        
        for i in 0..<nums.count {
            if map[nums[i]] == nil {
                map[nums[i]] = 1
            }else {
                let num = map[nums[i]]! + 1
                map[nums[i]] = num
            }
        }
        
        var result:[[Int]] = [[Int]]()
        
        for i in 0..<nums.count-2 {
            for j in i+1..<nums.count-1 {
                if map[-(nums[i] + nums[j])] != nil {
                    var count = map[-(nums[i] + nums[j])]! // 这个数出现的次数
                    
                    if nums[i] == -(nums[i] + nums[j]) {
                        count -= 1
                    }
                    if nums[j] == -(nums[i] + nums[j]) {
                        count -= 1
                    }
                    if count > 0 {
                        let num = [nums[i],nums[j],-(nums[i] + nums[j])].sorted()
                        if !result.contains(num) {
                            result.append(num)
                        }
                    }
                }
            }
        }
        return result
    }
}


class Solution_2 {
    
    /*
     方法三 ： 先排序 然后遍历 数组 ，遍历的时候才去两个指针一个从当前数的下一个开始 另一个从数组结尾开始 ，判断这两个数的和是否等于当前的数 

     */
    
    func threeSum(_ nums: [Int]) -> [[Int]] {
        if nums.count < 3 {
            return [[Int]]()
        }
        var newNums =   nums.sorted()
        
        var result:[[Int]] = [[Int]]()
        
        for i in 0..<newNums.count - 2 {
            if i > 0 && newNums[i] == newNums[i-1] {
                continue
            }
            
            var left = i + 1
            var right = newNums.count - 1
            let need = 0 - newNums[i]
            
            while left < right {
                if newNums[left] + newNums[right] == need {
                    
                    let num = [newNums[i],newNums[left],newNums[right]]
                    
                    result.append(num)
                    
                    
                    while left < right && newNums[left] == newNums[left + 1] {
                        left += 1
                    }
                    while left < right && newNums[right] == newNums[right - 1] {
                        right -= 1
                    }
                    
                    left += 1
                    right -= 1
                    
                }else if newNums[left] + newNums[right] >= need {
                    right -= 1
                }else {
                    left += 1
                }
            }
        }
        return result
    }
}
