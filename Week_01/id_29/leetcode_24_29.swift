//
//  leetcode_24_29.swift
//  极客时间
//
//  Created by gavin hu on 2019/6/23.
//  Copyright © 2019 gavin hu. All rights reserved.
//

import Foundation


class Solution {
    /*:
     方法一 迭代  一个一个的替换 ，使用了三个指针来表示 pre前一个node cur 当前的node next 后一个node
     */
    func swapPairs(_ head: ListNode?) -> ListNode? {
        let dummyHead = ListNode.init(-1)
        dummyHead.next = head
        
        var pre = dummyHead
        var cur = head
        var next = head?.next
        
        while next != nil {
            cur?.next = next?.next
            next?.next = cur
            pre.next = next
            pre = cur!
            cur = cur?.next
            next = cur?.next
        }
        return dummyHead.next
    }
}



class Solution_1 {
    /*:
     方法二 递归的方式去做 交换前面两个 然后后面的子串使用递归的方式继续交换
     */
    func swapPairs(_ head: ListNode?) -> ListNode? {
        if head != nil || head?.next != nil {
            return head
        }
        let next = head?.next
        head?.next = swapPairs_1(next?.next)
        next?.next = head
        return next
    }
}
