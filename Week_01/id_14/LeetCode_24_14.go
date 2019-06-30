package main

import "fmt"

func main() {

	list := &ListNode{}
	for i, n, node := 0, 5, list; i < n; i++ {
		node.Val = i
		if i < n-1 {
			node.Next = &ListNode{} 
			node = node.Next
		}
	}
	fmt.Println(list.Next)
	fmt.Println(swapPairs(list.Next))
}
type ListNode struct {
	Val  int
	Next *ListNode
}

func swapPairs(head *ListNode) *ListNode {

	// iteration
	// return swapPairsWithIteration(head)

	// recursion
	return swapPairsWithRecursion(head)
}

// swapPairsWithIteration using iteration
func swapPairsWithIteration(head *ListNode) *ListNode {
	list := &ListNode{Next: head}
	pre := list
	for pre.Next != nil && pre.Next.Next != nil {
		cur, next := pre.Next, pre.Next.Next
		pre.Next, cur.Next, next.Next, pre = next, next.Next, cur, cur
	}
	return list.Next
}

// swapPairsWithRecursion using recursion
func swapPairsWithRecursion(head *ListNode) *ListNode {
	if head == nil || head.Next == nil {
		return head
	}
	next := head.Next
	head.Next = swapPairs(next.Next)
	next.Next = head
	return next
}

func (l *ListNode) String() string {
	node := l
	s := "["
	for node != nil {
		s += fmt.Sprintf("%v", node.Val)
		if node.Next != nil {
			s += ","
		}
		node = node.Next
	}
	s += "]"
	return s
}