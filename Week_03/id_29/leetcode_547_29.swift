//
//  leetcode_547_29.swift
//  极客时间
//
//  Created by gavin hu on 2019/7/7.
//  Copyright © 2019 gavin hu. All rights reserved.
//

import Foundation

class Solution {
    private var studentCount:Int = 0  // 学生数量
    private var isVisited:[Bool] = [Bool]()  // 有没有访问过
    private var M:[[Int]] = [[Int]]()
    
    func dfs(_ i:Int) {
        isVisited[i] = true
        print(isVisited)
        for j in 0..<studentCount {
            if !isVisited[j] && M[i][j] == 1{
                dfs(j)
            }
        }
    }
    
    func findCircleNum(_ M: [[Int]]) -> Int {
        var count = 0
        studentCount = M.count
        self.M = M
        isVisited = [Bool].init(repeating: false, count: studentCount)
        if studentCount == 0 {
            return count
        }
        
        for i in 0..<studentCount {
            if !isVisited[i] {
                count += 1
                dfs(i)
            }
        }
        return count
    }
}
