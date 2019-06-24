import javax.swing.tree.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }else if (root.left == null && root.right == null){
            return 1;
        }else{
            int left = maxDepth(root.left);
            int right = maxDepth(root.right);
            int dep =  left > right ? left : right;
            return ++dep ;
        }
    }
}