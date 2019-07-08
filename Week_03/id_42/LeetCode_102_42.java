import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;

public class LeetCode_102_42 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();

        levelOrderHelper(root, 0, list);

        return list;
    }

    private void levelOrderHelper(TreeNode root, int depth, List<List<Integer>> list) {
        if (root == null)
            return;
        // 如采用中序/后序遍历，需将if改成while
        if (depth >= list.size()) {
            list.add(new ArrayList<>());
        }

        list.get(depth).add(root.val);

        levelOrderHelper(root.left, depth + 1, list);
        levelOrderHelper(root.right, depth + 1, list);
    }

    @Test
    public void test() {
        String str = "[3,9,20,null,null,15,7]";
        TreeNode tree = TreeNode.mkTree(str);
        levelOrder(tree);
    }
}
