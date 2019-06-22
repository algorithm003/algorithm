package main

import "fmt"

/**
111. 二叉树的最小深度
*/

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

/**
广度搜索
*/
func minDepth(root *TreeNode) int {
	if root == nil {
		return 0
	}

	var list = []*TreeNode{root}
	flag := 0
	for len(list) > 0 {
		flag++
		for i := len(list); i > 0; i-- {
			node := list[0]
			list = list[1:]
			leftNode := node.Left
			rightNode := node.Right
			// 判断是叶子节点，
			if leftNode == nil && rightNode == nil {
				list = list[:0]
				break
			}
			if leftNode != nil {
				list = append(list, leftNode)
			}
			if rightNode != nil {
				list = append(list, rightNode)
			}
		}
	}
	return flag
}

func main() {
	root := &TreeNode{Val: 1}
	root.Left = &TreeNode{Val: 2}
	root.Right = &TreeNode{Val: 3}
	root.Right.Left = &TreeNode{Val: 4}

	fmt.Println(minDepth(root))
}
