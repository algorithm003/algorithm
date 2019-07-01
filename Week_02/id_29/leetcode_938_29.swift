//
//  leetcode_938_29.swift
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
    func rangeSumBST(_ root: TreeNode?, _ L: Int, _ R: Int) -> Int {
        guard root != nil else {
            return 0
        }
        if root!.val < L  {
            return rangeSumBST(root?.right, L, R)
        }
        if root!.val  > R {
            return rangeSumBST(root?.left, L, R)
        }
        return root!.val + rangeSumBST(root?.right, L, R) + rangeSumBST(root?.left, L, R)
    }
}
