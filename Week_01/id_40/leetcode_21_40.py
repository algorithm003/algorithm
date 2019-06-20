# https://leetcode-cn.com/problems/merge-two-sorted-lists/

# 思路 1: 递归法
# 操作类问题, 而非输出类问题, 通常有返回值, 返回值是下一个符合要求的节点
# 终止条件: 其中一个节点为空, 此时返回另一个节点. 就算是空也没关系.
# 处理逻辑: 判断两个节点值的大小, 就让较小的那个的 next 指向下一个待确定的节点
# 递归下沉: 将较小节点的下一个结点, 和较大结点作为入参传入本函数
# 返回值 : 较小节点
# 时间复杂度: O(m+n)
# 空间复杂度: O(m+n)

from typing import List

# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution1:
    def mergeTwoLists(self, l1: ListNode, l2: ListNode) -> ListNode:
        # terminator
        if not l1:
            return l2
        if not l2:
            return l1

        # process & drill down
        if l1.val <= l2.val:
            l1.next = self.mergeTwoLists(l1.next, l2)
            return l1
        else:
            l2.next = self.mergeTwoLists(l2.next, l1)
            return l2

# 思路 2: 迭代法
# 增加头结点, 双指针 + 单指针. 单指针用于 "织网", 从 prehead 开始持续维护已经符合要求的节点. 双指针用于分别遍历比较两个链表. 最后返回 prehead.next.
# 易错点: 有好几次忘记迭代单指针 cur 本身, 一定要注意!!
# 时间复杂度: O(m+n)
# 空间复杂度: O(1)

class Solution2:
    def mergeTwoLists(self, l1: ListNode, l2: ListNode) -> ListNode:
        if not l1:
            return l2
        if not l2:
            return l1

        prehead = ListNode(0)
        p1, p2 = l1, l2
        cur = prehead
        while  p1 and p2:
            if p1.val <= p2.val:
                cur.next = p1
                p1 = p1.next
            else:
                cur.next = p2
                p2 = p2.next
            cur = cur.next

        while p1:
            cur.next = p1
            p1 = p1.next
            cur = cur.next
        while p2:
            cur.next = p2
            p2 = p2.next
            cur = cur.next

        return prehead.next
