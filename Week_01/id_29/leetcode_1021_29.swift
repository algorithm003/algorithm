//
//  leetcode_1021_29.swift
//  极客时间
//
//  Created by gavin hu on 2019/6/23.
//  Copyright © 2019 gavin hu. All rights reserved.
//

import Foundation

class Solution {
    
    /*
     实现思路：要删除最外层的括号 所以第一个“(”不需要添加到新创建的字符串里面 保持l括号正确的情况下最后一个“）”不需要添加到新创建的字符串 
     */
    
    func removeOuterParentheses(_ S: String) -> String {
        var res:String = String()
        var left = 0
        for c in S {
            if c == "(" {
                left += 1
                if left > 1 {
                    res.append(c)
                }
            }else if c == ")"  {
                left -= 1
                if left > 0 {
                    res.append(c)
                }
            }
        }
        return res
    }
}
