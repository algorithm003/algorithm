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
    
    /** 
    *it is a recursion problem. we must konw characteristics of searching binary trees
    */
    public int rangeSumBST(TreeNode root, int L, int R) {
        if(root == null) {
            return 0;
        }
        
        if(root.val<L) {
            return rangeSumBST(root.right, L, R);
        }
        
        if(root.val>R){
            return rangeSumBST(root.left, L, R);
        }
        
        return root.val+rangeSumBST(root.right, L, R)+rangeSumBST(root.left, L, R);
        
    }
}