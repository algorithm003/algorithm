/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func levelOrder(root *TreeNode) [][]int {

	if root == nil {
		return [][]int{}
	}
	levels, queue := make([][]int, 0), make([]*TreeNode, 0)
	queue = append(queue, root)

	for len(queue) > 0 {

		n, level := len(queue), make([]int, 0)

		for i := 0; i < n; i++ {
			node := queue[0]
			level, queue = append(level, node.Val), queue[1:]
			if node.Left != nil {
				queue = append(queue, node.Left)
			}
			if node.Right != nil {
				queue = append(queue, node.Right)
			}
		}

		levels = append(levels, level)

	}

	return levels
}


