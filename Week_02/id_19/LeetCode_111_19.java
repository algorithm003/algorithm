/**
二叉树的解题法一般会用DBS和BFS，此题用了递归也就是DFS
时间复杂度为O（n）
 */
class Solution {
    public int minDepth(TreeNode root) {
        // 递归结束条件
        if(root == null) {
            return 0;
        }
        int m1 = minDepth(root.left);
        int m2 = minDepth(root.right);
        return root.left == null || root.right == null? m1+m2+1: Math.min(m1,m2)+1;

    }
}

// 格式