//
//  leetcode_111_29.swift
//  极客时间
//
//  Created by gavin hu on 2019/6/23.
//  Copyright © 2019 gavin hu. All rights reserved.
//

import Foundation

class Solution {

    /*
     使用递归：
     这里重写了 min 方法
     最小深度是从根节点到最近叶子节点的最短路径上的节点数量。在[1, 2]对应的树中，很明显，结点1不是叶子结点，结点2才是。所以比较的时候 如何左边是0 返回右边的最小值 ，右边是0 返回左边的最小值 左边小于右边返回左边 ，否则就是右边
     */
    
    func min(_ a: Int, _ b: Int) -> Int {
        if a == 0 {
            return b
        } else if b == 0 {
            return a
        }
        return a < b ? a : b
    }
    
    func minDepth(_ root: TreeNode?) -> Int {
        guard let root = root else { return 0 }
        
        //min(minDepth(root?.left), minDepth(root?.right))
        
        return min(minDepth_1(root.left), minDepth_1(root.right)) + 1
    }
}
