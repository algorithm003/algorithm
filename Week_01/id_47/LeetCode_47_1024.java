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
        if(head == null
            || head.next == null) {
            return head;
        }
        
        ListNode curr = head;
        head = curr.next;  
    
        ListNode next = null;
        ListNode prev = null;
        do {
            next = curr.next;
            curr.next = next.next;
            next.next = curr;
            
            if(prev != null) {
                prev.next = next;
            }
            prev = curr;
            curr = curr.next;
        } while( curr != null && curr.next != null);
        
        return head;
    }
}