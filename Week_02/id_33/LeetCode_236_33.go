//+build ignore

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

/**
循环
*/
func lowestCommonAncestor1(root, p, q *TreeNode) *TreeNode {
	pVal, qVal := p.Val, q.Val
	for root != nil {
		rVal := root.Val
		if pVal < rVal && qVal < rVal {
			// 在左边
			root = root.Left
		} else if pVal > rVal && qVal > rVal {
			// 在右边
			root = root.Right
		} else {
			// 在两边或有一个为当前点，返回
			break
		}
	}
	return root
}

/**
递归
*/
func lowestCommonAncestor(root, p, q *TreeNode) *TreeNode {
	rVale, pVal, qVal := root.Val, p.Val, q.Val
	if pVal < rVale && qVal < rVale {
		return lowestCommonAncestor(root.Left, p, q)
	} // 左边
	if pVal > rVale && qVal > rVale {
		return lowestCommonAncestor(root.Right, p, q)
	} // 右边
	return root
}

func main() {
	root := &TreeNode{Val: 6}
	root.Left = &TreeNode{Val: 2}
	root.Right = &TreeNode{Val: 8}
	root.Left.Left = &TreeNode{Val: 0}
	root.Left.Right = &TreeNode{Val: 4}
	root.Right.Left = &TreeNode{Val: 7}
	root.Right.Right = &TreeNode{Val: 9}
	root.Left.Right.Left = &TreeNode{Val: 3}
	root.Left.Right.Right = &TreeNode{Val: 5}

	fmt.Println(lowestCommonAncestor(root, root.Left, root.Right))
}
