//
//  leetcode_111_29.swift
//  极客时间
//
//  Created by gavin hu on 2019/6/30.
//  Copyright © 2019 gavin hu. All rights reserved.
//

import Foundation


public class TreeNode {
    public var val: Int
    public var left: TreeNode?
    public var right: TreeNode?
    public init(_ val: Int) {
        self.val = val
        self.left = nil
        self.right = nil
    }
}


class Solution {
    func min(_ a: Int, _ b: Int) -> Int {
        if a == 0 {
            return b
        } else if b == 0 {
            return a
        }
        return a < b ? a : b
    }
    
    func minDepth(_ root: TreeNode?) -> Int {
        guard root != nil else {return 0}
        return min(minDepth(root?.left), minDepth(root?.right)) + 1
    }
}

