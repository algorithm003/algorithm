class Solution {
    func isSymmetric(_ root: TreeNode?) -> Bool {
        guard let root = root else {
            return true
        }
   
        var queue: [TreeNode?] = []
        queue.append(root.left)
        queue.append(root.right)
        while !queue.isEmpty {
            let t1 = queue.removeFirst()
            let t2 = queue.removeFirst()
            if t1 == nil && t2 == nil {
                continue
            }
            if t1 == nil || t2 == nil {
                return false
            }
            if t1?.val != t2?.val {
                return false
            }
            queue.append(t1?.left)
            queue.append(t2?.right)
            queue.append(t1?.right)
            queue.append(t2?.left)
        }
        return true
    }
}
