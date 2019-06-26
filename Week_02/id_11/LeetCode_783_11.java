/**
 * 783. 二叉搜索树结点最小距离
 * https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes/
 */
class Solution {
    /**
     * 第二次写这题，出现的问题：
     * 1.pre赋值位置不清楚，其实是对中序遍历代码理解不清
     * 2.没有考虑到pre为null的边界情况
     *  */
    private int min = Integer.MAX_VALUE;
    private TreeNode pre = null;

    public int minDiffInBST(TreeNode root) {
        dfs(root);
        return min;
    }

    public void dfs(TreeNode root) {
        if (root == null)
            return;

        dfs(root.left);
        if(pre!=null){
        min = Math.min(root.val - pre.val, min);
        }
        pre = root;
        dfs(root.right);
    }

}

// QC: 格式