package main

import "fmt"

/**
236. 二叉树的最近公共祖先
*/

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func lowestCommonAncestor(root, p, q *TreeNode) *TreeNode {
	if root == nil || root.Val == p.Val || root.Val == q.Val {
		return root
	} // 找到位置
	left := lowestCommonAncestor(root.Left, p, q)
	right := lowestCommonAncestor(root.Right, p, q)
	if left == nil { // 左边没有，在右边
		return right
	} else if right == nil { // 右边没有，在左边
		return left
	} else { // 左右都有，在中间
		return root
	}
}

func main() {
	root := &TreeNode{Val: 3}
	root.Left = &TreeNode{Val: 5}
	root.Right = &TreeNode{Val: 1}
	root.Left.Left = &TreeNode{Val: 6}
	root.Left.Right = &TreeNode{Val: 2}
	root.Right.Left = &TreeNode{Val: 0}
	root.Right.Right = &TreeNode{Val: 8}
	root.Left.Right.Left = &TreeNode{Val: 7}
	root.Left.Right.Right = &TreeNode{Val: 4}

	fmt.Println(lowestCommonAncestor(root, root.Left, root.Right))
}
