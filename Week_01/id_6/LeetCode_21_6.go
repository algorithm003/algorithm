/*
 * @lc app=leetcode.cn id=21 lang=golang
 *
 * [21] 合并两个有序链表
 *
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/description/
 *
 * algorithms
 * Easy (53.80%)
 * Likes:    490
 * Dislikes: 0
 * Total Accepted:    77.4K
 * Total Submissions: 140.4K
 * Testcase Example:  '[1,2,4]\n[1,3,4]'
 *
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 *
 * 示例：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 *
 *
 */
/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
 func mergeTwoLists(l1 *ListNode, l2 *ListNode) *ListNode {
	//哨兵节点
 preHead := &ListNode{
	 Val: -1,
 }

 if l1 == nil {
	 return l2
 }else if l2 == nil {
	 return l1
 }

 pre := preHead
 for l1 != nil && l2 != nil {
	 if l1.Val <= l2.Val {
		 pre.Next = l1
		 l1 = l1.Next
	 }else {
		 pre.Next = l2
		 l2 = l2.Next
	 }
	 pre = pre.Next
 }

 // 下面的循环不需要；直接赋值next指针即可

 //l1的元素多余l2的元素
 for l1 != nil  {
	 pre.Next = l1
	 l1 = l1.Next
	 pre = pre.Next
 }

 //l2的元素多余l1的元素
 for l2 != nil  {
	 pre.Next = l2
	 l2 = l2.Next
	 pre = pre.Next
 }

 return preHead.Next
}