//
//  leetcode_50_29.swift
//  极客时间
//
//  Created by gavin hu on 2019/6/23.
//  Copyright © 2019 gavin hu. All rights reserved.
//

import Foundation


class Solution {
    /*
     方法一 :暴力法   遍历 1 到 n 每次都做 x*x 时间复杂度 O(n)
     */
    
    func myPow(_ x: Double, _ n: Int) -> Double {
        if x == Double(0) {
            return 0
        }
        
        if n == 0 {
            return 1
        }
        
        var res:Double = 1
        let p = n < 0 ? -n : n
        
        for _ in 1...p {
            res = res * x
        }
        return n > 0 ? res : 1/res
    }
}


class Solution1 {
    /*
     方法二 ： 二分法  因为x^n = x^(n/2) * x^(n/2)  这样的话时间复杂度是O(log(n))
     */
    
    func myPow_1(_ x: Double, _ n: Int) -> Double {
        if x == Double(0) || n == 0 {
            return 1
        }
        
        let p = n < 0 ? -n : n
        var res:Double = 1
        
        if n == 1 {
            return x
        }
        res = myPow_1(x, p/2)
        if p % 2 == 0 {
            res = res * res
        }else {
            res = res * res * x
        }
        
        return n > 0 ? res : 1/res
    }
}
