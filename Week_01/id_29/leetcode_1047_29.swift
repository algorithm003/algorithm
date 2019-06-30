//
//  leetcode_1047_29.swift
//  极客时间
//
//  Created by gavin hu on 2019/6/23.
//  Copyright © 2019 gavin hu. All rights reserved.
//

import Foundation
class Solution {
    
    /*
     实现思路：使用栈的方式，入栈的时候跟栈顶元素进行比较 如果栈顶元素等于当前元素 则弹出栈顶元素
     否则入栈
     */
    
    func removeDuplicates(_ S: String) -> String {
        var res:String = String()
        for c in S {
            if res.isEmpty || res.last! != c{
                res.append(c)
            }else {
                res.popLast()
            }
        }
        return res
    }
}
