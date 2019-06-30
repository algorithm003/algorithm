//
//  leetcode_103_29.swift
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
    
    func kzigzagLevelOrder(_ root: TreeNode? ,_ level: Int)  {
        if res.count == level {
            res.append([Int]())
        }

        if level % 2 == 0 {
            res[level].append(root!.val)
        }else {
            res[level].insert(root!.val, at: 0)
        }
        
        if root?.left != nil {
            kzigzagLevelOrder(root?.left, level + 1)
        }
        
        if root?.right != nil {
            kzigzagLevelOrder(root?.right, level + 1)
        }
    }
    
    func zigzagLevelOrder(_ root: TreeNode?) -> [[Int]] {
        guard root != nil else {
            return res
        }
        kzigzagLevelOrder(root, 0)
        return res
    }
}
