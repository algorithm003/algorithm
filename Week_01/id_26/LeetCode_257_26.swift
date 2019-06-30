class Solution {
    var paths: [String] = []
    func binaryTreePaths(_ root: TreeNode?) -> [String] {
        guard let root = root else {
            return []
        }
        findPath(root, "\(root.val)")
        return paths
    }
    
    func findPath(_ root: TreeNode, _ path: String) {
        // terminator
        if root.left == nil && root.right == nil {
            paths.append(path)
            return 
        }
        if root.left != nil {
            findPath(root.left!, path + "->" + "\(root.left!.val)")
        }
        
        if root.right != nil {
            findPath(root.right!, path + "->" + "\(root.right!.val)")
        }
    }
}
