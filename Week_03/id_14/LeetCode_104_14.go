/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */

func maxDepth(root *TreeNode) int {
	if root == nil {
		return 0
	}
	return 1 + int(math.Max(float64(maxDepth(root.Left)), float64(maxDepth(root.Right))))
}

func maxDepth1(root *TreeNode) int {
	if root == nil {
		return 0
	}

	ld, rd := maxDepth(root.Left), maxDepth(root.Right)

	if ld > rd {
		return ld + 1
	} else {
		return rd + 1
	}

}

