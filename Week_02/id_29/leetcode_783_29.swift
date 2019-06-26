//
//  leetcode_783_29.swift
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

    func midOrder(_ root:TreeNode?,_ orderList: inout [Int]) {
        if root == nil { return }
        midOrder(root?.left,&orderList)
        orderList.append(root!.val)
        midOrder(root?.right,&orderList)
    }


    func minDiffInBST(_ root: TreeNode?) -> Int {
        var orderList:[Int] = [Int]()
        midOrder(root,&orderList)
        var res = Int.max
        for i in 1..<orderList.count  {
            res = min(res, orderList[i] - orderList[i-1])
        }
    }
}

// 代码很好！