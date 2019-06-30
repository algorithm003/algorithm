/**
 * @author: Suhb
 * @date: 2019/6/19 21:48
 * @description: 21. 合并两个有序链表
 */
public class LeetCode_21_035 {

    class ListNode {
        public int val;
        public ListNode next;
        public ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {   // 链表1如果没有了，就直接返回2就行，不用判断了
            return l2;
        }
        if (l2 == null) {   // 链表2如果没有了，就直接返回1就行，不用判断了
            return l1;
        }
        if (l1.val  >= l2.val) {    // 如果链表1的值大于等于2的话，那就取链表2的值，那链表2的下一个值就等于，链表1的所有值和链表2的下一值始开始作比较
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        } else {    // 如果链表1的值小于2的话，那就取链表1的值，那链表1的下一个值就等于，链表1的下一个值开始和链表2的作比较
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }
    }

    public static void main(String[] args) {
        int array[] = new int[]{1, 2, 4};
        /* 输入内容： */
        int lenth = array.length;
        LeetCode_21_035.ListNode headNode = (new LeetCode_21_035()).new  ListNode(array[0]);
        LeetCode_21_035.ListNode parentNode = headNode;                                                 // head下一个节点的父节点，每次下移会改变此值
        for (int i = 1; i < lenth; i++) {
            LeetCode_21_035.ListNode listNodeNext = (new LeetCode_21_035()).new  ListNode(array[i]);   // 创建当前新节点
            parentNode.next = listNodeNext;                                                            // 父节点的下一个节点为当前新节点
            parentNode = listNodeNext;                                                                 //  父节点下移
        }
        parentNode = headNode;
        while(parentNode != null) {
            System.out.print(parentNode.val + " -> ");
            parentNode = parentNode.next;
        }
        //
        System.out.println();
        int array2[] = new int[]{1, 3, 4};
        /* 输入内容： */
        int lenth2 = array2.length;
        LeetCode_21_035.ListNode headNode2 = (new LeetCode_21_035()).new  ListNode(array[0]);
        LeetCode_21_035.ListNode parentNode2 = headNode2;                                                 // head下一个节点的父节点，每次下移会改变此值
        for (int i = 1; i < lenth2; i++) {
            LeetCode_21_035.ListNode listNodeNext = (new LeetCode_21_035()).new  ListNode(array2[i]);   // 创建当前新节点
            parentNode2.next = listNodeNext;                                                            // 父节点的下一个节点为当前新节点
            parentNode2 = listNodeNext;                                                                 //  父节点下移
        }
        parentNode2 = headNode2;
        while(parentNode2 != null) {
            System.out.print(parentNode2.val + " -> ");
            parentNode2 = parentNode2.next;
        }
        //
        System.out.println();
        /* 输出结果 */
        parentNode = new LeetCode_21_035().mergeTwoLists(headNode, headNode2);
        while(parentNode.next != null) {
            System.out.print(parentNode.val + " -> ");
            parentNode = parentNode.next;
        }
        System.out.print(parentNode.val);
    }
}
