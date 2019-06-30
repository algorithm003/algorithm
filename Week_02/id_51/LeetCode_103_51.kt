import java.util.*

class Solution {
    fun zigzagLevelOrder(root: TreeNode?): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        val queue = LinkedList<TreeNode>().also {
            root?.run { it.add(this) }
        }

        var level = 1
        while (!queue.isEmpty()) {
            val levelResult = mutableListOf<TreeNode>()
            while (!queue.isEmpty()) {
                levelResult += queue.poll()
            }
            result += levelResult.map { it.`val` }.let { if (level++ % 2 == 0) it.reversed() else it }
            levelResult.forEach {
                it.left?.run { queue += this }
                it.right?.run { queue += this }
            }
        }
        return result
    }
}
