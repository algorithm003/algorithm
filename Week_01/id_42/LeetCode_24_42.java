//给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。 
//
// 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。 
//
// 
//
// 示例: 
//
// 给定 1->2->3->4, 你应该返回 2->1->4->3.
// 
//

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */

class Solution24 {
    private ListNode node = new ListNode(0);

    public ListNode swapPairs(ListNode firstNode) {
        if (firstNode == null) {
            return null;
        }

        ListNode secondNode = firstNode.next;
        if (secondNode == null) {
            return firstNode;
        }
        firstNode.next = secondNode.next;
        secondNode.next = firstNode;
        firstNode.next = swapPairs(firstNode.next);

        return secondNode;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(8);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        Solution24 solution = new Solution24();

        solution.swapPairs(l1);
    }
}