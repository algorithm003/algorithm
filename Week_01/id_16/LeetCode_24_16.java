public class LeetCode024 {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode virtualHead = new ListNode(-1);
        virtualHead.next = head;
        ListNode p1 = head;
        ListNode p2 = head.next;
        ListNode tmp;
        ListNode pre = virtualHead;

        do {
            pre.next = p2;
            tmp = p2.next;
            p2.next = p1;
            p1.next = tmp;
            pre = p1;
            p1 = p1.next;
            if (p1 != null) {
                p2 = p1.next;
            }
        } while (p1 != null && p2 != null);

        return virtualHead.next;
    }
}
