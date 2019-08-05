//
//  leetcode_121_29.swift
//  极客时间
//
//  Created by gavin hu on 2019/7/21.
//  Copyright © 2019 gavin hu. All rights reserved.
//

import Foundation

class Solution {
    func maxProfit(_ prices: [Int]) -> Int {
        
        guard prices.count > 0 else {
            return 0
        }
        
        var dp:[[Int]] = [[Int]].init(repeating: [Int].init(repeating: 0, count: 2), count: prices.count)
        
        for i in 0..<prices.count {
            if i - 1 == -1 {
                dp[i][0] = 0
                dp[i][1] = -prices[i]
                continue
            }
            dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i])
            dp[i][1] = max(dp[i-1][1], -prices[i])
        }
        print(dp)
        return dp[prices.count-1][0]
    }
}

class Solution1 {
    func maxProfit(_ prices: [Int]) -> Int {
        let n = prices.count
        var dp_i_0 = 0
        var dp_i_1 = Int.min
        
        for i in 0..<n {
            dp_i_0 = max(dp_i_0, dp_i_1 + prices[i])
            dp_i_1 = max(dp_i_1, -prices[i])
        }
        return dp_i_0
    }
}
