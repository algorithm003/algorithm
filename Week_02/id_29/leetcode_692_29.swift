//
//  leetcode_692_29.swift
//  极客时间
//
//  Created by gavin hu on 2019/6/30.
//  Copyright © 2019 gavin hu. All rights reserved.
//

import Foundation
class Solution {
    func topKFrequent(_ words: [String], _ k: Int) -> [String] {
        
        var res:[String] = [String]()
        var map:[String:Int] = [String:Int]()
        
        for word in words {
            if map[word] == nil {
                map[word] = 1
            }else {
                map[word] = map[word]! + 1
            }
        }
        
        let priorityQueue =  map.sorted { (dic1, dic2) -> Bool in
            if dic1.value != dic2.value {
                return dic1.value > dic2.value
            }else {
                return dic1.key < dic2.key
            }
        }
        
        for item in priorityQueue {
            res.append(item.key)
            if res.count == k {
                return res
            }
        }
        
        return res
    }
}
