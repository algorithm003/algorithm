//+build ignore

package main

import "fmt"

/**
101. 对称二叉树
*/

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

/**
广度搜索
*/
func isSymmetric1(root *TreeNode) bool {
	if root == nil {
		return true
	}

	var list []*TreeNode
	list = append(list, root)
	for len(list) > 0 {
		length := len(list)
		if length == 1 {
			list = append(list[:0], root.Left, root.Right)
			continue
		}
		lenSplit := length / 2
		var listTemp []*TreeNode
		for i := 0; i < length; i++ {
			node := list[0]
			list = list[1:]
			if i < lenSplit {
				listTemp = append(listTemp, node)
			} else {
				rightNode := listTemp[length-i-1]
				if node != rightNode && (node == nil || rightNode == nil || node.Val != rightNode.Val) {
					return false
				}

			}
			if node != nil {
				list = append(list, node.Left, node.Right)
			}
		}
	}
	return true
}

/**
递归
*/
func isSymmetric(root *TreeNode) bool {
	return root == nil || dp(root.Left, root.Right)
}

func dp(left, right *TreeNode) bool {
	if left == nil || right == nil {
		return left == right
	}
	if left.Val != right.Val {
		return false
	}
	return dp(left.Left, right.Right) && dp(left.Right, right.Left)
}

func main() {
	root := &TreeNode{Val: 1}
	root.Left = &TreeNode{Val: 2}
	root.Right = &TreeNode{Val: 2}
	root.Left.Left = &TreeNode{Val: 3}
	root.Left.Right = &TreeNode{Val: 4}
	root.Right.Left = &TreeNode{Val: 4}
	root.Right.Right = &TreeNode{Val: 3}

	fmt.Println(isSymmetric(root))
}
