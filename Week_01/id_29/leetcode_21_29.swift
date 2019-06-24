//
//  leetcode_21_29.swift
//  极客时间
//
//  Created by gavin hu on 2019/6/23.
//  Copyright © 2019 gavin hu. All rights reserved.
//

import Foundation


public class ListNode {
    public var val: Int
    public var next: ListNode?
    public init(_ val: Int) {
        self.val = val
        self.next = nil
    }
}

class Solution {
    
    /*
     采用递归来合并两个有序链表  因为两个子链表是有序的 所以合并的时候可以采用递归的方式
     # 递归终止条件: 其中一个节点为空, 此时返回另一个节点. 就算是空也没关系.
     # 处理逻辑: 判断两个节点值的大小, 就让较小的那个的 next 指向下一个待确定的节点
     # 递归下沉: 将较小节点的下一个结点, 和较大结点作为入参传入本函数
     # 返回值 : 较小节点
     */
    
    func mergeTwoLists(_ l1: ListNode?, _ l2: ListNode?) -> ListNode? {
        if l1 == nil || l2 == nil {
            return l1 == nil ? l2 : l1
        }
        
        if l1!.val < l2!.val {
            l1?.next = mergeTwoLists(l1?.next, l2)
            return l1
        }else{
            l2?.next = mergeTwoLists(l1, l2?.next)
            return l2
        }
    }
}
