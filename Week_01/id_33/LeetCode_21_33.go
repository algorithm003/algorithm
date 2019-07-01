//+build ignore

package main

import (
	"fmt"
)

/**
21. 合并两个有序链表
*/

type ListNode struct {
	Val  int
	Next *ListNode
}

func mergeTwoLists1(l1 *ListNode, l2 *ListNode) *ListNode {
	// 新根结点
	root := ListNode{}
	pre := &root
	// 遍历完其中一个
	for l1 != nil && l2 != nil {
		if l1.Val <= l2.Val {
			pre.Next = l1
			l1 = l1.Next
		} else {
			pre.Next = l2
			l2 = l2.Next
		}
		pre = pre.Next
	}
	// 加上剩余大的一个
	if l1 == nil {
		pre.Next = l2
	} else {
		pre.Next = l1
	}
	return root.Next
}

/**
递归，每次返回小的
*/
func mergeTwoLists(l1 *ListNode, l2 *ListNode) *ListNode {
	if l1 == nil {
		return l2
	}
	if l2 == nil {
		return l1
	}
	if l1.Val <= l2.Val {
		l1.Next = mergeTwoLists(l1.Next, l2)
		return l1
	} else {
		l2.Next = mergeTwoLists(l1, l2.Next)
		return l2
	}
}

func main() {
	l1 := &ListNode{Val: 1}
	l1.Next = &ListNode{Val: 2}
	l1.Next.Next = &ListNode{Val: 4}
	l2 := &ListNode{Val: 1}
	l2.Next = &ListNode{Val: 3}
	l2.Next.Next = &ListNode{Val: 4}

	lists := mergeTwoLists(l1, l2)
	fmt.Println(lists)
}
