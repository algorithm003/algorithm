package main

import "fmt"


// TreeNode is tree's node
type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func minDepth(root *TreeNode) int {
	switch {
	case root == nil:
		return 0
	case root.Left == nil:
		return 1 + minDepth(root.Right)
	case root.Right == nil:
		return 1 + minDepth(root.Left)
	default:
		return 1 + min(minDepth(root.Left), minDepth(root.Right))
	}
}

func min(a int, b int) int {
	if a < b {
		return a
	}
	return b
}

// ints2TreeNode 利用 []int 生成 *TreeNode
func ints2TreeNode(ints []int) *TreeNode {
	n := len(ints)
	if n == 0 {
		return nil
	}

	root := &TreeNode{
		Val: ints[0],
	}

	queue := make([]*TreeNode, 1, n*2)
	queue[0] = root

	i := 1
	for i < n {
		node := queue[0]
		queue = queue[1:]

		if i < n {
			node.Left = &TreeNode{Val: ints[i]}
			queue = append(queue, node.Left)

			node.Right = &TreeNode{Val: ints[i]}
			queue = append(queue, node.Right)
		}
		i += 2
	}

	return root
}

func main()  {
	nums := []int{3, 9, 20, 15, 7}
	root := ints2TreeNode(nums)
	fmt.Println("结果是：", minDepth(root))
}