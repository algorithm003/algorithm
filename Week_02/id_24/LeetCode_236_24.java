package week2.lowestCommonAncestorofaBinaryTree;

/**
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 * According to the <a href="https://en.wikipedia.org/wiki/Lowest_common_ancestor">definition of LCA on Wikipedia</a>: 
 * "The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow <b>a node to be a descendant of itself</b>)."
 */
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    	if(root == null || root == p || root == q) return root;
    	TreeNode left = lowestCommonAncestor(root.left, p, q);
    	TreeNode right = lowestCommonAncestor(root.right, p, q);
    	
    	// If root in left contains p or q; And right contains p or q
    	// This root is the LCA
    	if(left != null && right != null) {
    		return root;
    	} else {
    		// else the LCA must in one of the left or right sub tree.
    		// return the non null sub tree
    		return left != null ? left : right;
    	}
    }

	public static void main(String[] args) {
		Solution s = new Solution();
		
		TreeNode root = new TreeNode(3);
		TreeNode left = new TreeNode(5);
		root.left = left;
		left.left = new TreeNode(6);
		TreeNode leftRight = new TreeNode(2);
		left.right = leftRight;
		leftRight.left = new TreeNode(7);
		leftRight.right = new TreeNode(4);
		
		TreeNode right = new TreeNode(1);
		right.left =  new TreeNode(0);
		right.right = new TreeNode(8);
		root.right = right;
		System.out.println(s.lowestCommonAncestor(root, left, right).val);
		
	}

}


class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}