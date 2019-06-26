class Solution {

    public ListNode swapPairs(ListNode head) {
        // 终止条件只有一个结点或者无结点
        if (head == null || head.next == null) {
            return head;
        }

        ListNode nextNode = head.next;
        // 递归条件 f(n) = f(n+1)
        head.next = swapPairs(nextNode.next);
        nextNode.next = head;
        return nextNode;
    }
}
