//
//  leetcode_714_29.swift
//  极客时间
//
//  Created by gavin hu on 2019/7/21.
//  Copyright © 2019 gavin hu. All rights reserved.
//

import Foundation


class Solution {
    func maxProfit(_ prices: [Int], _ fee: Int) -> Int {
        
        let n = prices.count
        var dp_i_0 = 0
        var dp_i_1 = Int.min
        
        for i in 0..<n {
            let temp = dp_i_0
            dp_i_0 = max(dp_i_0, dp_i_1 + prices[i])
            dp_i_1 = max(dp_i_1, temp - prices[i] - fee)
        }
        return dp_i_0
    }
}
