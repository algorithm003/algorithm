package main

import "fmt"

/**
24. 两两交换链表中的节点
*/

type ListNode struct {
	Val  int
	Next *ListNode
}

/**
从上一节点开始，依次交换
*/

func swapPairs1(head *ListNode) *ListNode {
	var root = new(ListNode)
	root.Next = head
	pre := root
	for pre.Next != nil && pre.Next.Next != nil {
		//pre.Next, pre.Next.Next, pre.Next.Next.Next = pre.Next.Next, pre.Next.Next.Next, pre.Next
		a := pre.Next
		b := a.Next
		pre.Next, a.Next, b.Next = b, b.Next, a
		pre = a.Next

	}
	return root.Next
}

/**
递归，每次返回交换后的头指针
*/
func swapPairs(head *ListNode) *ListNode {
	if head == nil || head.Next == nil {
		return head
	}
	temp := head.Next
	head.Next = swapPairs(temp.Next)
	temp.Next = head
	return temp
}

func main() {
	node := &ListNode{Val: 1}
	node.Next = &ListNode{Val: 2}
	node.Next.Next = &ListNode{Val: 3}
	node.Next.Next.Next = &ListNode{Val: 4}

	node = swapPairs(node)
	for node != nil {
		fmt.Println(node.Val)
		node = node.Next
	}
}
