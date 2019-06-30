class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


"""
    @author: Merlin 2019.06.23
    24.Swap Nodes In Pairs
    思路: 用两个指针不断交换元素，并移动指针到下一组要交换的元素即可
    例子: 交换相邻两个节点，1->2->3->4->5，交换后得2->1->4->3->5
    time: O(n) space: O(1)
"""
class Solution:
    def swapPairs(self, head):
        pre, pre.next = self, head
        while pre.next and pre.next.next:
            a = pre.next
            b = a.next
            pre.next, b.next, a.next = b, a, b.next
            pre = a
        return self.next