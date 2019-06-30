//
//  leetcode_88_29.swift
//  极客时间
//
//  Created by gavin hu on 2019/6/23.
//  Copyright © 2019 gavin hu. All rights reserved.
//

import Foundation

class Solution {
    /*
     先把nums2 加到nums1 里面 ，然后再使用快排 时间复杂度O(nlog(n)) 空间复杂度O(1)
     */
    func merge(_ nums1: inout [Int], _ m: Int, _ nums2: [Int], _ n: Int) {
        var index = m
        for i in 0..<n {
            nums1[index] = nums2[i]
            index += 1
        }
        nums1.sort()
    }
}


class Solution1 {
    /*
     从后面往前面合并 空间复杂度O(1) 时间复杂度O(n)
     分析：因为 nums1 nums2是有序的所有合并后也是有序的，并且因为nums1 很大，所以可以从nums1 和  nums2的后面开始比较 ，将大的放到 m+ n - 1的位置 ，依此类推
     */
    func merge(_ nums1: inout [Int], _ m: Int, _ nums2: [Int], _ n: Int) {
        var i = m - 1
        var j = n - 1
        
        var k = m + n - 1
        
        while i >= 0 && j >= 0 {
            if nums1[i] > nums2[j] {
                nums1[k] = nums1[i]
                i -= 1
                k -= 1
            }else {
                nums1[k] = nums2[j]
                k -= 1
                j -= 1
            }
        }
        
        while j >= 0 {
            nums1[k] = nums2[j]
            k -= 1
            j -= 1
        }
    }
}


class Solution2 {
    /*
    新创建一个数组 空间复杂度O(n) 时间复杂度O(n)
     */
    func merge(_ nums1: inout [Int], _ m: Int, _ nums2: [Int], _ n: Int) {
        var array = [Int]()
        
        if n == 0 {
            return
        }
        
        var p = 0 ,q = 0
        
        while p < m && q < n {
            if nums1[p] < nums2[q] {
                array.append(nums1[p])
                p += 1
            } else {
                array.append(nums2[q])
                q += 1
            }
        }
        
        if m > p {
            for i in p..<m{
                array.append(nums1[i])
            }
        }
        
        if n > q {
            for i in q..<n{
                array.append(nums2[i])
            }
        }
        nums1 = array
    }
}
