//
//  leetcode_783_29.swift
//  极客时间
//
//  Created by gavin hu on 2019/6/23.
//  Copyright © 2019 gavin hu. All rights reserved.
//

import Foundation

class Solution {
    
    func dfs(_ root: TreeNode? ,_ low:Int,_ high:Int , _ res:inout Int) {
        if root == nil { return }
        if low != Int.min { res = min(res, root!.val - low) }
        if high != Int.min { res = min(res, high - root!.val) }
        dfs(root?.left,low,root!.val,&res)
        dfs(root?.right,root!.val,high,&res)
    }
    
    
    func minDiffInBST(_ root: TreeNode?) -> Int {
        var res:Int = Int.max
        dfs(root, Int.min, Int.max, &res)
        return res
    }
    
}
