#Author:kilien
#Leetcode 24.Swap Nodes in Pairs
#思路：定义哨兵节点，互换相邻节点及后继节点，详见图解
#time:O(n)  space:O(n)
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None
class Solution:
    def swapPairs(self, head: ListNode) -> ListNode:
        pre, pre.next = self, head
        while pre.next and pre.next.next:
            a = pre.next
            b = a.next
            pre.next, b.next, a.next = b, a, b.next
            pre = a
        return self.next
