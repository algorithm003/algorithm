//
//  leetcode_101_29.swift
//  极客时间
//
//  Created by gavin hu on 2019/6/23.
//  Copyright © 2019 gavin hu. All rights reserved.
//

import Foundation

class Solution {
    
    /*
     思路：使用递归来实现 对称二叉树的规则是 左子树的左子树 等于 右子树的右子树 ，左子树的右子树等于 右子树的左子树
     */
    
    func isMirror(_ left:TreeNode? ,_ right:TreeNode?) -> Bool{
        if left == nil && right != nil  || left != nil && right == nil{
            return false
        }
        if left == nil && right == nil {
            return true
        }
        
        return left!.val == right!.val &&
            isMirror(left?.left, right?.right) &&
            isMirror(left?.right, right?.left)
    }
    
    
    func isSymmetric(_ root: TreeNode?) -> Bool {
        return isMirror(root?.left,root?.right)
    }
}
