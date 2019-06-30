class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


"""
    @author: Merlin 2019.06.23
    21.Merge Two Sorted Lists
    思路: 因为链表是有序的，所以遍历两条链表并比较两条链表中的元素，再重新组合成一条新的链表即可
    假设l1链表总长度为m，l2链表总长度为n
    time: O(m + n) space: O(1)
"""
class Solution:
    def mergeTwoLists(self, l1: ListNode, l2: ListNode) -> ListNode:
        head = root = ListNode(None)
        while l1 and l2:
            if l1.val < l2.val:
                head.next = l1
                l1 = l1.next
            else:
                head.next = l2
                l2 = l2.next
            head = head.next
        head.next = l1 or l2
        return root.next