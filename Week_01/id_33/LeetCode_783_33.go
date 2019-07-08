//+build ignore

package main

import (
	"fmt"
)

/**
783. 二叉搜索树结点最小距离
*/

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

/**
二叉搜索树，中序有序
*/
func minDiffInBST(root *TreeNode) int {
	maxInt := 200
	minInt := -200
	// 定义两指针，一个保存当前最小值，一个保存前一个值，由于值在 2 - 100
	cur, pre := &maxInt, &minInt

	inorder(root, cur, pre)
	return *cur
}

func inorder(root *TreeNode, cur, pre *int) {
	if root == nil {
		return
	}
	inorder(root.Left, cur, pre)
	*cur = min(*cur, root.Val-*pre)
	*pre = root.Val
	inorder(root.Right, cur, pre)
}

func min(a, b int) int {
	if a < b {
		return a
	}
	return b
}

func main() {
	root := &TreeNode{Val: 4}
	root.Left = &TreeNode{Val: 2}
	root.Right = &TreeNode{Val: 6}
	root.Left.Left = &TreeNode{Val: 1}
	root.Left.Right = &TreeNode{Val: 3}

	fmt.Println(minDiffInBST(root))
}
