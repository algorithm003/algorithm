# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:

    '''
    建立一个头指针指向头结点，并建立一个pre结点移动到下一个两两调转的结点之前。
    第一次进入while循环时，pre.next指向了b，也就原本顺序中的第二个结点，此时dump也会指向该结点b，因为初始化时是pre = dumnp
    但后面一句pre = a之后，pre与dump就不再有关联，dump.next将始终指向b，也就是新的头结点
    '''
    def swapPairs(self, head: ListNode) -> ListNode:
        dump = ListNode(0)
        pre, dump.next = dump, head

        while pre.next and pre.next.next:
            a = pre.next
            b = a.next
            pre.next, a.next, b.next = b, b.next, a
            pre = a

        return dump.next