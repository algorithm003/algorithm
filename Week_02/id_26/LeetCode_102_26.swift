class Solution {
    private var results: [[Int]] = []
    // DFS
    func levelOrder(_ root: TreeNode?) -> [[Int]] {
        guard let root = root else {
            return []
        }
        dfs(root, 0)
        return results
    }
    
    // level start from 0
    func dfs(_ root: TreeNode, _ level: Int) {
        // add the current level node
        if level == results.count {
            results.append([])
        }
        results[level].append(root.val)
        
        if root.left == nil && root.right == nil {
            return
        }
        if let leftNode = root.left {
            dfs(leftNode, level + 1)
        }
        if let rightNode = root.right {
            dfs(rightNode, level + 1)
        }
    }
}
