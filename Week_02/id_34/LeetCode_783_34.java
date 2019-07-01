/**
 * @author jinjw
 * @date 2019/6/30
 * @description 给定一个二叉搜索树的根结点 root, 返回树中任意两节点的差的最小值
 */
public class LeetCode_783_34 {
    int min = Integer.MAX_VALUE;
    TreeNode pre;

    public int minDiffInBST(TreeNode root) {
        if (root == null) return 0;
        minDiffInBST(root.left);
        if (pre != null && (root.val - pre.val) < min) {
            min = root.val - pre.val;
        }
        pre = root;
        minDiffInBST(root.right);
        return min;
    }


    public int minDiffInDFS(TreeNode root) {
        dfs(root);
        return min;
    }

    private void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);
        if (pre != null) min = Math.min(root.val - pre.val, min);
        pre = root;
        dfs(root.right);
    }
}
