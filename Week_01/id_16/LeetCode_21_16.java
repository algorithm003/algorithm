public class LeetCode021 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return null;
        }

        ListNode head = new ListNode(-1);
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        ListNode curPointer = new ListNode(-1);
        curPointer = head.next;

        do {
            if (cur1 != null && cur2 != null) {
                if (cur1.val <= cur2.val) {
                    curPointer = cur1;
                    cur1 = cur1.next;
                } else {
                    curPointer = cur2;
                    cur2 = cur2.next;
                }
                curPointer = curPointer.next;
            } else {
                if (cur1 == null) {
                    curPointer = cur2;
                    cur2 = cur2.next;
                }
                else {
                    curPointer = cur1;
                    cur1 = cur1.next;
                }
            }
        } while (cur1 != null || cur2 != null);

        return head.next;
    }
}
