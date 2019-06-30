//
//  leetcode_104_29.swift
//  极客时间
//
//  Created by gavin hu on 2019/6/23.
//  Copyright © 2019 gavin hu. All rights reserved.
//

import Foundation

class Solution {
    
    /*
     思路：使用递归来实现 最大深度为左子树的最大深度 或者右子树的最大深度 中的最大值 + 1
     */
    
    func maxDepth(_ root: TreeNode?) -> Int {
        if root == nil {
            return 0
        }else{
            return max(maxDepth(root?.left), maxDepth(root?.right)) + 1
        }
    }
}
