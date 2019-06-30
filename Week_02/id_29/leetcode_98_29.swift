//
//  leetcode_98_29.swift
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
    func _kisValidBST(_ root: TreeNode?,_ vals:inout [Int]) {
        if root == nil { return }
        _kisValidBST(root?.left, &vals)
        vals.append(root!.val)
        _kisValidBST(root?.right, &vals)
    }
    
    
    func isValidBST(_ root: TreeNode?) -> Bool {
        var res = true
        var vals = [Int]()
        _kisValidBST(root, &vals)
        
        if vals.count < 2 {
            return res
        }
        
        for i in 1..<vals.count {
            if vals[i] <= vals[i-1] {
                res = false
            }
        }
        return res
    }
}
