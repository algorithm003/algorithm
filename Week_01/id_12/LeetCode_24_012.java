/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummyHead = new ListNode(1);
        dummyHead.next = head;

        ListNode p = dummyHead;
        while(p.next != null && p.next.next != null){
            ListNode node1 = p.next;
            ListNode node2 = p.next.next;
            ListNode next = node2.next;
            // swap node1 node2
            node2.next = node1;
            node1.next = next;
            p.next = node2;
            p = node1;
        }

        ListNode retNode = dummyHead.next;
        dummyHead.next = null;
        return retNode;

    }
}