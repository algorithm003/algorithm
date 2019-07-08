//
//  leetcode_102_29.swift
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
    
    var res:[[Int]] = [[Int]]()
    
    func klevelOrder(_ root: TreeNode? ,_ level: Int)  {
        if res.count == level {
            res.append([Int]())
        }
        res[level].append(root!.val)
        if root?.left != nil {
            klevelOrder(root?.left, level + 1)
        }
        if root?.right != nil {
            klevelOrder(root?.right, level + 1)
        }
    }
    
    func levelOrder(_ root: TreeNode?) -> [[Int]] {
        guard root != nil else { return res }
        klevelOrder(root, 0)
        return res
    }
}
