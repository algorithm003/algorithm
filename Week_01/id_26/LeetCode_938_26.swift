class Solution {
    private var sums: Int = 0
    private var result: [Int] = []
    func rangeSumBST(_ root: TreeNode?, _ L: Int, _ R: Int) -> Int {
        inOrderBST(root)
        for (_, value) in result.enumerated() {
            if value >= L && value <= R {
                sums += value
            }
        }
        return sums
    }
    
    func inOrderBST(_ root: TreeNode?) {
        guard let root = root else {
            return
        }
        inOrderBST(root.left)
        result.append(root.val)
        inOrderBST(root.right)
    }
}
