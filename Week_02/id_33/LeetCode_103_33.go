//+build ignore

package main

import "fmt"

/**
103. 二叉树的锯齿形层次遍历
*/

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

/**
广度搜索
*/
func zigzagLevelOrder(root *TreeNode) [][]int {
	var result [][]int
	if root == nil {
		return result
	}

	list := []*TreeNode{root}
	// 子节点是否从左往右
	right := true
	for len(list) > 0 {
		length := len(list)
		nums := make([]int, length)
		for i := 0; i < length; i++ {
			node := list[0]
			list = list[1:]
			// 从左往右，顺序；否则，逆序
			if right {
				nums[i] = node.Val
			} else {
				nums[length-i-1] = node.Val
			}
			if node.Left != nil {
				list = append(list, node.Left)
			}
			if node.Right != nil {
				list = append(list, node.Right)
			}
		}
		right = !right
		result = append(result, nums)
	}
	return result
}

func main() {
	root := &TreeNode{Val: 3}
	root.Left = &TreeNode{Val: 9}
	root.Right = &TreeNode{Val: 20}
	root.Right.Left = &TreeNode{Val: 15}
	root.Right.Right = &TreeNode{Val: 7}

	fmt.Println(zigzagLevelOrder(root))

}
