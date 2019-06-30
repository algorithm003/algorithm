/**
 * [236] 二叉树的最近公共祖先
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/comments/
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 当前节点的子树存在p或者q节点时返回当前p/q，否则为null
        if(root==null) return null;
        if(root==p||root==q) return root;
        TreeNode left= lowestCommonAncestor(root.left, p, q);
        TreeNode right=lowestCommonAncestor(root.right, p, q);
        // 如果两个子树或者当前节点有两个不为null，则说明当前节点为LCA
        if(left!=null&&right!=null) return root;
        if(left!=null) return left;
        if(right!=null) return right;
        return null;
    }
}