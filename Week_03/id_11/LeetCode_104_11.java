public class LeetCode_104_11 {
  
    public int maxDepth(TreeNode root) {
        if (root == null){return 0;}
        else{
            int left = maxDepth(root.left);
            int right = maxDepth(root.right);
            return Math.max(left,right);
        }
    }


     public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}