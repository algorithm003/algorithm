/**
 * @author: Suhb
 * @date: 2019/6/19 09:45
 * @description:
 */
public class LeetCode_24_035 {

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {                 // terminator
            return head;
        }
        ListNode nexNode = head.next;                             // 获取当前层的下一层
        head.next = swapPairs(nexNode.next);                    // 当前层的下一层是相邻层再隔一层相邻交换后的数据
        nexNode.next = head;                                     // 下一层的下一层与当前层调换
        return nexNode;
        /*ListNode all = new ListNode(0);                         // 每隔一层就交换当前及下一层的数据，所以需要在数据开始前创建多一层，形成重复操作
        all.next = head;                                           // 将传入的数据放在新创建的层级后面
        ListNode temp = all;                                       // 需要处理的所有链表数据
        while(temp.next != null && temp.next.next != null) {       // 因为每隔一层处理一次数据
            ListNode start = temp.next;                            // 需要处理的从第一位开始
            ListNode end = temp.next.next;                         // 需要处理的第二位开始
            temp.next = end;                                       // 调换提前
            start.next = end.next;                                // 第一位的下一位等于第二位的下一位开始
            end.next = start;                                      // 第二位的下一位等于第一位开始
            temp = start;                                           // 需要处理的数据跳到当前第一位处理后的层级开始
        }
        return all.next;                                           // 第一位不需要*/
    }

    class ListNode {
        public int val;
        public ListNode next;
        public ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        int array[] = new int[]{1, 2, 3, 4};
        /* 输入内容： */
        int lenth = array.length;
        LeetCode_24_035.ListNode headNode = (new LeetCode_24_035()).new  ListNode(array[0]);
        LeetCode_24_035.ListNode parentNode = headNode;                                                 // head下一个节点的父节点，每次下移会改变此值
        for (int i = 1; i < lenth; i++) {
            LeetCode_24_035.ListNode listNodeNext = (new LeetCode_24_035()).new  ListNode(array[i]);   // 创建当前新节点
            parentNode.next = listNodeNext;                                                            // 父节点的下一个节点为当前新节点
            parentNode = listNodeNext;                                                                 //  父节点下移
        }
        parentNode = headNode;
        while(parentNode.next != null) {
            System.out.print(parentNode.val + " -> ");
            parentNode = parentNode.next;
        }
        System.out.print(parentNode.val);

        System.out.println();
        /* 输出结果 */
        parentNode = new LeetCode_24_035().swapPairs(headNode);
        while(parentNode.next != null) {
            System.out.print(parentNode.val + " -> ");
            parentNode = parentNode.next;
        }
        System.out.print(parentNode.val);
    }
}
