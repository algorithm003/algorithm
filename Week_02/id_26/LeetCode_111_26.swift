class Solution {
    private var minLevel = Int.max
    
    func minDepth(_ root: TreeNode?) -> Int {
        guard let root = root else {
            return 0
        }
        dfs(root, 1)
        return minLevel
    }
    
    func dfs(_ root: TreeNode?, _ level: Int) {
        if root?.left == nil && root?.right == nil {
            minLevel = level < minLevel ? level : minLevel
            return
        }
        if root?.left != nil {
            dfs(root?.left, level + 1)
        }
        if root?.right != nil {
            dfs(root?.right, level + 1)
        } 
    }
}
