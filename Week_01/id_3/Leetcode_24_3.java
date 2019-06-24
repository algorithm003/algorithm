package app;

/**
 * @author zhongzuoming <zhongzuoming, 1299076979@qq.com>
 * @version v1.0
 * @Description
 * @encoding UTF-8
 * @date 2019/6/22
 * @time 17:30
 * @修改记录 <pre>
 * 版本       修改人         修改时间         修改内容描述
 * --------------------------------------------------
 * <p>
 * --------------------------------------------------
 * </pre>
 */
public class LeetCode24 {
    public static void main(String[] args) throws Exception {
        ListNode listNode1 = new ListNode(1);

        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);

        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        ListNode head = new ListNode(0);
        head.next = listNode1;
        ListNode curNode = listNode1;
        while (null != curNode) {
            System.out.println(curNode.val);
            curNode = curNode.next;
        }
        ListNode sec = recurseiveListNode(listNode1);
        ListNode curNode1 = sec;
        System.out.println("转化之后====");
        while (null != curNode1) {
            System.out.println(curNode1.val);
            curNode1 = curNode1.next;
        }
    }

    public static ListNode swapPairs(ListNode head) {
        if (head == null)
            return head;
        if (head.next == null)
            return head;

        ListNode newHead = head.next; // save a reference to the new head (second node now if exists)

        ListNode prev = null; // second of the last pair (already swapped)
        ListNode node = head; // first of the next pair (to be swapped)
        while (node != null && node.next != null) {
            if (prev == null) {// for the first pair
                ListNode temp = node.next;
                node.next = node.next.next;
                temp.next = node;
            } else {
                prev.next = node.next;
                node.next = prev.next.next;
                prev.next.next = node;
            }

            prev = node;
            node = node.next;
        }

        return newHead;
    }

    public static ListNode recurseiveListNode(ListNode head) {
        if (null == head || null == head.next){
            return head;
        }
c
        ListNode nextCurrent = head.next.next;
        ListNode nextHead = head.next;
        nextHead.next = head;
        head.next = recurseiveListNode(nextCurrent);
        return nextHead;
    }
}
