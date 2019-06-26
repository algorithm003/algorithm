package week2.minimumDepthofBinaryTree;

/**
 * Given a binary tree, find its minimum depth.
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 */
public class Solution {
    public int minDepth(TreeNode root) {
    	return _minDepth(0, root);
    }

    // Recursion
    private int _minDepth(int level, TreeNode root) {
    	if(root == null) return 0;

    	int left = _minDepth(level++, root.left);
    	int right = _minDepth(level++, root.right);

    	// When left or right min level is 0 that means it's a single branch tree or it's the leaf node
    	if(left == 0 || right == 0) {
			// count the higher branch level when each or the child level is 0 and continue.

			// QC: neat!! 厉害
    		return left + right + 1;
    	}

    	return Math.min(left, right) + 1;
    }

	public static void main(String[] args) {
		Solution s = new Solution();
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		TreeNode right = new TreeNode(20);
		right.left =  new TreeNode(15);
		right.right = new TreeNode(7);
		root.right = right;
		System.out.println(s.minDepth(root));

		TreeNode root1 = new TreeNode(0);
		System.out.println(s.minDepth(root1));
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