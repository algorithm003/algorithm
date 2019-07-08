//
//  leetcode_104_29.swift
//  极客时间
//
//  Created by gavin hu on 2019/7/7.
//  Copyright © 2019 gavin hu. All rights reserved.
//

import Foundation

/*:
 方法一 ：递归
 */

class Solution {
    func maxDepth(_ root: TreeNode?) -> Int {
        if root == nil {
            return 0
        }
        return 1 + max(maxDepth(root?.left), maxDepth(root?.right))
    }
}

/*
 方法二 迭代法
 */

class Solution1 {
    
    struct NewTreeNode {
        public var depth:Int
        public var node:TreeNode
        init(_ node:TreeNode,_ depth:Int) {
            self.depth = depth
            self.node = node
        }
    }
    
    func maxDepth(_ root: TreeNode?) -> Int {
        var maxDepth = 0
        if root == nil {
            return maxDepth
        }
        
        var queue:[NewTreeNode] = [NewTreeNode]()
        queue.append(NewTreeNode(root!, 1))
        while queue.count > 0 {
            let newNode = queue.removeFirst()
            maxDepth = max(maxDepth, newNode.depth)
            if newNode.node.left != nil {
                queue.append(NewTreeNode.init(newNode.node.left!, maxDepth + 1))
            }
            if newNode.node.right != nil {
                queue.append( NewTreeNode.init(newNode.node.right!, maxDepth + 1))
            }
            
        }
        return maxDepth
    }
}

