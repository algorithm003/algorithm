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

    return max(maxDepth(root.Left), maxDepth(root.Right)) + 1
}

func max(a, b int) int {

    if a > b {
        return a
    }

    return b
}


// 不要上面这个函数！