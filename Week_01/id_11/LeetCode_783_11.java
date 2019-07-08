/**
 * [783] 二叉搜索树结点最小距离
 * https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes/
 */
class Solution {
    private TreeNode pre = null;
    private int min = Integer.MAX_VALUE;
    public int minDiffInBST(TreeNode root) {
         dfs(root);
         return min;
    }
    // 中序遍历求相邻节点的差值最小值
    public void dfs(TreeNode root) {
        if (root == null) return;
            dfs(root.left);
            if(pre!=null){
            min=Math.min( root.val-pre.val,min);
            }
            pre=root;
            dfs(root.right);
    }

}