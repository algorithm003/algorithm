//
//  leetcode_26_29.swift
//  极客时间
//
//  Created by gavin hu on 2019/6/23.
//  Copyright © 2019 gavin hu. All rights reserved.
//

import Foundation


class Solution {
    
    /*双指针法.慢指针维护目标排序位置,快指针用于遍历整个原数组.遍历时比较两指针的值,若相同则说明对于当前的 i 位置,快指针经历的 j 位置仍处于重复值,不同则时说明此时 nums[j] 是刚好紧邻且比 nums[i] 大的值,应当写入 nums[i+1] .最后别忘了右移 i.最终的长度比 i 多 1,故返回 i+1 即可.

     # 时间复杂度: O(n)
     # 空间复杂度: O(1)
*/
    
    func removeDuplicates(_ nums: inout [Int]) -> Int {
        if nums.count == 0 || nums.count == 1 {
            return nums.count
        }
        
        var i = 0
        for j in 1..<nums.count {
            if nums[i] != nums[j] {
                i += 1
                nums[i] = nums[j]
            }
        }
        return i + 1
    }
    
    
    
    
    /*
     方法二
     不要使用额外的数组空间 所以只能在当前的数组进行操作 ，想法就是把重复的下标记住 ，并且移除 ，因为移除数组会导致数组个数发生改变 ，所以我这里采用while 循环 ，当不重复的时候 index + 1 ，去除重复元素的时候 index 不变 ，这样一轮遍历之后 ，就可以移除掉相应的重复元素
     */
    func removeDuplicates_1(_ nums: inout [Int]) -> Int {
        if nums.count == 0 || nums.count == 1{
            return nums.count
        }
        var curNum = nums[0]
        var index = 1
        while index < nums.count {
            if curNum == nums[index] {
                nums.remove(at: index)
            }else{
                curNum = nums[index]
                index += 1
            }
            
        }
        return nums.count
    }
}


