class Solution {
    func maxDepth(_ root: TreeNode?) -> Int {
        // terminator
        if root == nil {
            return 0
        }
        
        return max(maxDepth(root?.left), maxDepth(root?.right)) + 1
    }
}
