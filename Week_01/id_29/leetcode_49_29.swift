//
//  leetcode_49_29.swift
//  极客时间
//
//  Created by gavin hu on 2019/6/23.
//  Copyright © 2019 gavin hu. All rights reserved.
//

import Foundation

class Solution {
    
    /*
     方法一：
     #1 遍历的时候 对数组里面的字符进行排序 ，并将其放入相应的map 里面
     #2 遍历map 获取它的所有value
     时间复杂度O(n)*O(klog(k))
     */
    
    func groupAnagrams(_ strs: [String]) -> [[String]] {
        var result:[[String]] = [[String]]()
        
        var map:[String:[String]] =  [String:[String]]()
        
        for str in strs {
            var strChars = Array.init(str)
            strChars.sort()
            if map[String.init(strChars)] == nil {
                map[String.init(strChars)] = [str]
            }else{
                map[String.init(strChars)]!.append(str)
            }
        }
        
        for val in map.values {
            result.append(val)
        }
        
        return result
    }
}

class Solution_1 {
    
    /*
     方法二：
     */
    
    func groupAnagrams(_ strs: [String]) -> [[String]] {
        var result:[[String]] = [[String]]()
        var map:[[Int]:[String]] = [[Int]:[String]]()
        
        for str in strs {
            var num:[Int] = Array .init(repeating: 0, count: 26)
            let strChars:[Character] = Array.init(str)
            
            for char in strChars {
                let index = char.toInt() - Character.init("a").toInt()
                num[index] =  num[index] + 1
            }
            
            if map[num] == nil {
                map[num] = [str]
            }else{
                map[num]?.append(str)
            }
        }
        
        for val in map.values {
            result.append(val)
        }
        return result
    }
}
