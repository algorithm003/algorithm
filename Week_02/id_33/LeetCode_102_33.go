//+build ignores

package main

import "fmt"

/**
102. 二叉树的层次遍历
*/

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

/**
深度搜索
*/
func levelOrder(root *TreeNode) [][]int {
	result := make([][]int, 0)
	if root == nil {
		return result
	}
	dfs(0, root, &result)
	return result
}
func dfs(level int, root *TreeNode, result *[][]int) {
	// 新增一行
	if len(*result) <= level {
		*result = append(*result, []int{})
	}
	// 添加列数
	(*result)[level] = append((*result)[level], root.Val)

	if root.Left != nil {
		dfs(level+1, root.Left, result)
	}
	if root.Right != nil {
		dfs(level+1, root.Right, result)
	}
}

/**
广度搜索
*/
func levelOrder1(root *TreeNode) [][]int {
	var result [][]int
	if root == nil {
		return result
	}

	list := []*TreeNode{root}

	for len(list) > 0 {
		var nums []int

		// QC: 这里需要优化
		for i := len(list); i > 0; i-- {
			// QC: 这里需要优化
			node := list[0]
			list = list[1:]
			nums = append(nums, node.Val)

			if node.Left != nil {
				list = append(list, node.Left)
			}
			if node.Right != nil {
				list = append(list, node.Right)
			}
		}
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

	fmt.Println(levelOrder(root))

}
