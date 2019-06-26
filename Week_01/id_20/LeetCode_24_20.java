
/*
*
*   24. 两两交换链表中的节点
*   给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
*   你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
*
*   学号：020
*
* */


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {


    //方法一：循环将每相邻的两个节点交换位置，明显的缺点：代码难看长丑。
    public ListNode swapPairs1(ListNode head) {

        if (head == null || head.next == null){
            return head;
        }

        ListNode tempCur = head;            //记录当前两个相邻元素的第一个节点。
        ListNode tempNext = tempCur.next;   //记录当前两个相邻元素的第二个节点。
        head = tempNext;    //交换后，第二个元素变成了头结点

        ListNode tempPre = null;

        while (tempCur != null && tempNext != null){

            //两个节点交换位置
            tempCur.next = tempNext.next;
            tempNext.next = tempCur;

            if (tempPre != null){
                //当前组上个节点连接交换位置后的节点位置
                tempPre.next = tempNext;
            }

            //更新下一组节点的相应新位置
            tempPre = tempCur;
            tempCur = tempCur.next;

            //下移下一组相邻两个节点
            tempNext = ( tempCur != null ) ? ( tempNext = tempCur.next ) : ( tempNext = null );

        }
        return head;
    }


    //方法二：原理同上，但这个方式利用虚拟头结点，让代码更简洁。
    public ListNode swapPairs3(ListNode head) {

        //创建一个虚拟头结点
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode temp = pre;

        while ( temp.next != null && temp.next.next != null ){

            ListNode tempCur = temp.next;
            ListNode tempNext = temp.next.next;

            temp.next = tempNext;
            tempCur.next = tempNext.next;
            tempNext.next = tempCur;

            temp = tempCur;

        }

        return pre.next;

    }


    //方法三：递归返回调转每两个节点的新节点
    public ListNode swapPairs3(ListNode head) {

        if (head == null || head.next ==  null) {
            return head;
        }

        ListNode next = head.next;

        head.next = swapPairs(next.next);
        next.next = head;

        return next;

    }

}

// Good. 第一个方法还可以更加短一点。