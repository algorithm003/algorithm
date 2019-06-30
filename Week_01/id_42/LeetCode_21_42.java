/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode listNode = null;
        if (l1.val < l2.val) {
            listNode = new ListNode(l1.val);
            listNode.next = mergeTwoLists(l1.next, l2);
        } else {
            listNode = new ListNode(l2.val);
            listNode.next = mergeTwoLists(l1, l2.next);
        }
        return listNode;
    }
}