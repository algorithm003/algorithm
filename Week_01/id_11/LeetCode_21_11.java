/**
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 * 链接：https://leetcode-cn.com/problems/merge-two-sorted-lists/
 */
class Solution {
    
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode l3=head;
        while (l1!=null && l2!= null) {
            if (l1.val <l2.val) {
                l3.next=l1;
                l1 = l1.next;
            } else {
                l3.next = l2;
                l2 = l2.next;
            }
            l3=l3.next;
        }
        if(l1==null){
            l3.next=l2;
        }else{
            l3.next=l1;
        }
        return head.next;
    }
}
/**
 * 思考：
 * 该种解法的优点就是申请一个头节点，避免找头指针是哪个
 * 还有需要考虑其中一个链表为空的情况 
 */