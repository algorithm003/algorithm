//
//  leetcode_84_29.swift
//  极客时间
//
//  Created by gavin hu on 2019/6/23.
//  Copyright © 2019 gavin hu. All rights reserved.
//

import Foundation



class Solution {
    
    /*
     方法一 ：暴力法  我们可以想到，两个柱子间矩形的高由它们之间最矮的柱子决定  因此，我们可以考虑所有两两柱子之间形成的矩形面积，该矩形的高为它们之间最矮柱子的高度，宽为它们之间的距离，这样可以找到所要求的最大面积的矩形。
     
     这个方法 时间复杂度是o(n^2) 空间复杂度 o(1)
     
     */
    
    func largestRectangleArea(_ heights: [Int]) -> Int {
        var area = 0
        for index in 0..<heights.count {
            var cur = index
            var width = 1
            while cur - 1 >= 0 && heights[cur - 1] >= heights[index] {
                width += 1
                cur -= 1
            }
            cur = index
            while cur + 1 <  heights.count && heights[cur + 1] > heights[index] {
                width += 1
                cur += 1
            }
            if width * heights[index] > area  {
                area = width * heights[index]
            }
        }
        return area
    }
}


class Solution_1 {
    
    /*
     方法二：
     */
    
    func largestRectangleArea(_ heights: [Int]) -> Int {
        var area = 0
        var stack:[Int] = [Int]()
        stack.append(-1)
        
        for index in 0..<heights.count {
            while stack.last !=  -1  && heights[index] <= heights[stack.last!]  {
                let height = heights[stack.removeLast()]
                area = max(area, (index - stack.last! - 1) * height)
            }
            stack.append(index)
        }
        
        while stack.last! != -1 {
            let height = heights[stack.removeLast()]
            area = max(area, height * (heights.count - stack.last! - 1))
        }
        
        return area
    }
}
