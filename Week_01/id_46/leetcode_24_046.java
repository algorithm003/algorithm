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
    //递归
    //终止条件
        if(head == null || head.next == null)
            return head;
    //单元执行:交换head和head的下一个节点
        ListNode next = head.next;
        head.next = swapPairs(next.next);
        next.next = head;
    //返回值
        return next;
        
    }
    
}