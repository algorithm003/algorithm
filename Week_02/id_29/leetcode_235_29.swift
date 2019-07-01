//
//  leetcode_236_29.swift
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
    func lowestCommonAncestor(_ root:TreeNode?, _ p:TreeNode?,_ q:TreeNode?) -> TreeNode? {
        if root == nil { return nil }
        
        if p == nil || q == nil{
            return  p == nil ? q : p
        }
        
        if root!.val > max(p!.val, q!.val) {
            lowestCommonAncestor(root?.left, p, q)
        }else if root!.val < min(p!.val, q!.val) {
            lowestCommonAncestor(root?.right, p, q)
        }else {
            return root
        }
    }
}
