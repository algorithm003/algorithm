class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:

    '''
    合并两个链表，并有序排列，可以创建两个头指针dump和cur，再去遍历判断l1和l2的值大小，小的即被cur.next指向，
    同时l = l.next，l指向下一个，cur也要指向下一个。
    遍历完之后，再将不为空的l链表，接入cur的尾部
    最后用另一个头指针dump.next拿到第一个结点
    '''



    def mergeTwoLists(self, l1: ListNode, l2: ListNode) -> ListNode:
        dump = cur = ListNode(0)
        while l1 and l2:
            if l1.val < l2.val:
                cur.next = l1
                l1 = l1.next
            else:
                cur.next = l2
                l2 = l2.next
            cur = cur.next
        cur.next = l1 or l2
        return dump.next
