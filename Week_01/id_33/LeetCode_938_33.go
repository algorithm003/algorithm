//+build ignore

package main

import "fmt"

/**
938. 二叉搜索树的范围和
求 L<=?<=R之间的和
*/

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func rangeSumBST(root *TreeNode, L int, R int) int {
	if root == nil {
		return 0
	}
	val := root.Val
	result := 0
	// 累计符合的值
	if L <= val && val <= R {
		result += val
	}
	// 左边有
	if val > L {
		result += rangeSumBST(root.Left, L, R)
	}
	// 右边有
	if val < R {
		result += rangeSumBST(root.Right, L, R)
	}

	return result
}

func main() {
	root := &TreeNode{Val: 15}
	root.Left = &TreeNode{Val: 9}
	root.Right = &TreeNode{Val: 21}
	root.Left.Left = &TreeNode{Val: 7}
	root.Left.Right = &TreeNode{Val: 13}
	root.Right.Left = &TreeNode{Val: 19}
	root.Right.Right = &TreeNode{Val: 23}
	root.Left.Left.Left = &TreeNode{Val: 5}
	root.Left.Right.Left = &TreeNode{Val: 11}
	root.Right.Left.Left = &TreeNode{Val: 17}

	fmt.Println(rangeSumBST(root, 19, 21))
}
