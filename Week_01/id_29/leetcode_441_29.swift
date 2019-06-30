//
//  leetcode_441_29.swift
//  极客时间
//
//  Created by gavin hu on 2019/6/23.
//  Copyright © 2019 gavin hu. All rights reserved.
//

import Foundation

class Solution {
    /*
     方法一 ：暴力法  时间复杂度o(n)
     */
    func arrangeCoins(_ n: Int) -> Int {
        if n <= 1 {
            return n
        }
        var row = 0
        var num = n
        while row + 1 <= num {
            row += 1
            num -= (row)
        }
        return row
    }
}


class Solution1 {
    /*
     方法二： 推导数学公式  row*(row+1) = 2n  时间复杂度o(n)
     */
    
    func arrangeCoins_1(_ n: Int) -> Int {
        if n <= 1 {
            return n
        }
        
        var row = 1
        while row * (row + 1) <= 2*n  {
            row += 1
        }
        return row - 1
    }
}

class Solution2 {
    /*
     方法三： 二分法   还是运用了 求和公式row*(row+1) = 2n  ，但是我们这里在找这个row的时候 不是从1开始遍历 ，因为是有序的 所以我们可以 使用二分查找的方式 在1...n 里面进行查找 极大的提高查找效率 时间复杂度n(logn)
     */
    
    func arrangeCoins_2(_ n: Int) -> Int {
        if n <= 1 {
            return n
        }
        var left = 1
        var height = n
        while left < height {
            let mid = left + (height - left) / 2
            if mid * (mid + 1) / 2 <= n {
                left = mid + 1
            }else{
                height = mid
            }
        }
        return left - 1
    }
}
