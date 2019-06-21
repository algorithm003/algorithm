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
func isSymmetric(root *TreeNode) bool {
	if root == nil {
		return true
	}

	var list []*TreeNode
	list = append(list, root)
	for len(list) > 0 {
		var result []int
		for i := len(list); i > 0; i-- {
			node := list[0]
			if node != root {
				if len(result) > 0 && result[len(result)-1] == node.Val {
					result = result[:len(result)-1]
				} else {
					result = append(result, node.Val)
				}
			}
			list = list[1:]
			if node.Left != nil {
				list = append(list, node.Left)
			}
			if node.Right != nil {
				list = append(list, node.Right)
			}
		}

		if len(result) > 0 {
			return false
		}
	}
	return true
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
