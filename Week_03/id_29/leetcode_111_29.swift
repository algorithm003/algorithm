//
//  leetcode_111_29.swift
//  极客时间
//
//  Created by gavin hu on 2019/7/7.
//  Copyright © 2019 gavin hu. All rights reserved.
//

import Foundation

/**
 迭代
 */
class Solution {
    struct NewTreeNode {
        public var depth:Int
        public var node:TreeNode
        init(_ node:TreeNode,_ depth:Int) {
            self.depth = depth
            self.node = node
        }
    }
    
    func minDepth(_ root: TreeNode?) -> Int {
        if root == nil {
            return 0
        }
        var minDepth = Int.max
        var queue:[NewTreeNode] = [NewTreeNode]()
        queue.append(NewTreeNode(root!, 1))
        while queue.count > 0 {
            let newNode = queue.removeFirst()
            let currentDepth = newNode.depth
            if newNode.node.left == nil && newNode.node.right == nil {
                minDepth = min(minDepth, currentDepth)
            }
            if newNode.node.left != nil {
                queue.append(NewTreeNode.init(newNode.node.left!, currentDepth + 1))
            }
            if newNode.node.right != nil {
                queue.append( NewTreeNode.init(newNode.node.right!, currentDepth + 1))
            }
        }
        return minDepth
    }
}
