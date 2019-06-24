# https://leetcode-cn.com/problems/swap-nodes-in-pairs/

# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

# 思路 1: 递归法
# 先维护当前节点, 下个节点, 下个节点对的头节点, 然后进行递归处理.
# 1. 处理一个节点对
# 2. 这个节点对中后边那个节点的 next 指向下一个节点对中的头节点.
# 3. 通过递归获取下个节点对的头结点.
# 时间复杂度: O(n)
# 空间复杂度: O(n)

class Solution1:
    def swapPairs(self, head: ListNode) -> ListNode:
        # terminator
        if not head or not head.next:
            return head

        # process data
        next = head.next
        nexthead = next.next
        next.next = head
        # drill down
        head.next = self.swapPairs(nexthead)
        # return
        return next


# 思路 2: 头节点+迭代法
# 时间复杂度: O(n)
# 空间复杂度: O(1)

class Solution2:
    def swapPairs(self, head: ListNode) -> ListNode:
        if not head or not head.next:
            return head

        prehead = ListNode(0)
        p1 = head
        p2 = head.next
        result = p2
        prehead.next = p1

        while p2 and prehead and p1:
            # process
            tmpNext = p2.next
            p2.next = p1
            p1.next = tmpNext
            prehead.next = p2
            
            # prepare for next iteration
            prehead = p1
            p1 = prehead.next
            if p1:
                p2 = p1.next

        return result