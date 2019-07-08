#author:kilien
#Leetcode 206.Reverse Linked List
#思路：定义两个指针，指向前继节点和当前节点
#多元赋值，两两互换
#time:O(n)  space:O(1)
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def reverseList(self, head: ListNode) -> ListNode:
        cur, prev = head, None
        while cur:
            cur.next, prev, cur = prev, cur, cur.next
        return prev