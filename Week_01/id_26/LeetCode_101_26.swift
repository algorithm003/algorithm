class Solution {
    func isSymmetric(_ root: TreeNode?) -> Bool {
        return isMirror(root, root)
    }
    
    func isMirror(_ left: TreeNode?, _ right: TreeNode?) -> Bool {
        // terminator
        if (left == nil && right == nil) {
            return true
        }
        
        if (left == nil || right == nil) {
            return false
        }
        
        return (left?.val == right?.val)
            && isMirror(left?.right, right?.left)
            && isMirror(left?.left, right?.right)
    }
}
