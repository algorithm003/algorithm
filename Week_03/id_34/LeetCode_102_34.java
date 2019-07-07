import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author jinjw
 * @date 2019/7/7
 * @description 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 *     3
 *   / \
 * 9  20
 *   /  \
 * 15   7
 */
public class LeetCode_102_34 {
    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> levels = new ArrayList<>();
            if (root == null) return levels;
            Queue<TreeNode> queue = new LinkedList<TreeNode>();
            queue.add(root);
            int level = 0;
            while (!queue.isEmpty()) {
                levels.add(new ArrayList<Integer>());
                int level_length = queue.size();
                for (int i = 0; i < level_length; ++i) {
                    TreeNode node = queue.remove();
                    levels.get(level).add(node.val);
                    if (node.left != null) queue.add(node.left);
                    if (node.right != null) queue.add(node.right);
                }
                level++;
            }
            return levels;
        }
    }
}
