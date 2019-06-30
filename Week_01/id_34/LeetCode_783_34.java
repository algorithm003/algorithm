/**
 * @author jinjw
 * @date 2019/6/22
 * @description 给定一个二叉搜索树的根结点 root, 返回树中任意两节点的差的最小值。
 */
public class LeetCode_783_34 {
    TreeNode pre = null;
    int min =Integer.MAX_VALUE;
    public int minDiffInBST(TreeNode root) {
        _dfs(root);
        return min;
    }
    private void _dfs(TreeNode root){
        if (root ==null) return;
        _dfs(root.left);
        if(pre !=null) min = Math.min(root.val-pre.val,min);
        pre =root;
        _dfs(root.right);
    }
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
