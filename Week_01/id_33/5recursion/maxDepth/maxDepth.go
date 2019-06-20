package main

import "fmt"

/**
104. 二叉树的最大深度
*/

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

/**
dfs(深度优先搜索)
*/
func maxDepth(root *TreeNode) int {
	if root == nil {
		return 0
	}
	return dfs(root, 1)
}

func dfs(root *TreeNode, level int) int {
	if root == nil {
		return level - 1
	}
	leftLevel := dfs(root.Left, level+1)
	rightLevel := dfs(root.Right, level+1)
	if leftLevel > rightLevel {
		return leftLevel
	} else {
		return rightLevel
	}
}

/**
bfs(广度度优先搜索)
*/
func maxDepth1(root *TreeNode) int {
	if root == nil {
		return 0
	}

	var list []*TreeNode
	list = append(list, root)
	// visit

	depth := 0
	for len(list) > 0 {
		depth++
		for i := len(list); i > 0; i-- {
			node := list[0]
			list = list[1:]
			//fmt.Println(node.Val)
			if node.Left != nil {
				list = append(list, node.Left)
			}
			if node.Right != nil {
				list = append(list, node.Right)
			}

		}
	}
	return depth
}

func main() {
	root := &TreeNode{Val: 3}
	root.Left = &TreeNode{Val: 9}
	root.Right = &TreeNode{Val: 20}
	root.Right.Left = &TreeNode{Val: 15}
	root.Right.Right = &TreeNode{Val: 7}

	fmt.Println(maxDepth(root))
}

func toTree(nums []int) *TreeNode {
	root := &TreeNode{}
	root.Val = nums[0]

	var list []*TreeNode
	list = append(list, root)
	index := 0
	for len(list) > 0 {
		for i := len(list); i > 0; i-- {
			node := list[0]
			list = list[1:]
			if index+2 < len(nums) {
				index++
				node.Left = &TreeNode{Val: nums[index]}
				index++
				node.Right = &TreeNode{Val: nums[index]}
				list = append(list, node.Left, node.Right)
			} else {
				break
			}
		}
	}

	return root
}
