/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = dummyHead;
        ListNode l1p = l1;
        ListNode l2p = l2;
        while (l1p != null && l2p != null) {
            if(l1p.val < l2p.val) {
                p.next = l1p;
                l1p = l1p.next;
            } else {
                p.next = l2p;
                l2p = l2p.next;
            }
            p = p.next;
        }


        if(l1p != null) {
            p.next = l1p;
        } else {
            p.next = l2p;
        }
        ListNode ret = dummyHead.next;
        dummyHead.next = null;

        return ret;

    }
}