//
//  leetcode_101_29.swift
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
    
    func isMirror(_ left: TreeNode? ,_ right:TreeNode?) ->Bool {
        if left == nil && right != nil || left != nil && right == nil  {
            return false
        }
        if left == nil && right == nil {
            return true
        }
        return left!.val == right!.val  && isMirror(left?.left, right?.right) && isMirror(left?.right, right?.left)
    }
    
    func isSymmetric(_ root: TreeNode?) -> Bool {
        guard root != nil else { return true }
        return isMirror(root?.left, root?.right)
    }
}
