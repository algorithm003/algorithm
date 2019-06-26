import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeetCode_103_16 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean isReverse = false;
        while (!queue.isEmpty()) {

            // QC: List<Integer>
            LinkedList<Integer> oneLevel = new LinkedList<Integer>();
            int len = queue.size();
            for (int i = 0; i < len; i ++) {
                TreeNode node = queue.poll();
                if (!isReverse) {
                    oneLevel.add(node.val);
                }
                else {
                    oneLevel.addFirst(node.val);
                }

                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            isReverse = !isReverse;
            result.add(oneLevel);
        }
        return result;
    }
}
