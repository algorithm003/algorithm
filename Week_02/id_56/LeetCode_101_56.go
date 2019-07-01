/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func isSymmetric(root *TreeNode) bool {
    
    if root == nil {
        return true
    }
    
    return recur(root.Left, root.Right)
}

func recur(left, right *TreeNode) bool {
    
    if left == nil && right == nil {
        return true
    }
    
    if left == nil || right == nil {
        return false
    }
    
    return left.Val == right.Val && recur(left.Left, right.Right) && recur(left.Right, right.Left)

}
