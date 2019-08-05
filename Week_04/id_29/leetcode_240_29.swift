//
//  leetcode_240_29.swift
//  极客时间
//
//  Created by gavin hu on 2019/7/21.
//  Copyright © 2019 gavin hu. All rights reserved.
//

import Foundation

class Solution {
    func searchMatrix(_ matrix: [[Int]], _ target: Int) -> Bool {
        if matrix.count == 0 {
            return false
        }
        for var i in 0..<matrix.count {
            for var j in (0..<matrix[0].count).reversed() {
                if matrix[i][j] == target {
                    return true
                }else if matrix[i][j] > target && j - 1 >= 0  {
                    j = j - 1
                }else if matrix[i][j] < target && i + 1 < matrix.count{
                    i = i + 1
                }
            }
        }
        return false
    }
}
