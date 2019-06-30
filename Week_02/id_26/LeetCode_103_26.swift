class Solution {
    func zigzagLevelOrder(_ root: TreeNode?) -> [[Int]] {
        guard let root = root else {
            return []
        }
        
        var results: [[Int]] = []
        var queue: [TreeNode] = [root]
        // BFS
        var level = 0
        while !queue.isEmpty {
            let length = queue.count
            var levelList: [Int] = []
            for i in 0..<length {
                let curNode = queue.removeFirst()
                levelList.append(curNode.val)
                if let leftNode = curNode.left {
                    queue.append(leftNode)
                }
                if let rightNode = curNode.right {
                    queue.append(rightNode)
                }
            }
            if level & 1 == 1{
                levelList = levelList.reversed()
            }
            results.append(levelList)
            level += 1
        }
        return results
    }
}
