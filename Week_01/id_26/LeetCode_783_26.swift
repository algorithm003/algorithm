class Solution {
    private var min: Int = Int.max
    private var result: [Int] = []
    
    func minDiffInBST(_ root: TreeNode?) -> Int {
        inOrderBinaryTree(root)
        for i in 0..<result.count - 1 {
            min = Swift.min(min, result[i+1] - result[i])
        }
        return min
    }
    
    func inOrderBinaryTree(_ root: TreeNode?) {
        guard let root = root else {
            return
        }
        inOrderBinaryTree(root.left)
        result.append(root.val)
        inOrderBinaryTree(root.right)
    }
}
