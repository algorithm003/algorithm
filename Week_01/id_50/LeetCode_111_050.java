import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;



/**
 * @author yu
 * 二叉树的最小深度
 */
public class LeetCode_111_050 {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
	}

	public int minDepth(TreeNode root) {
        if(root == null){
			return 0;
		}else{
			if(root.left == null && root.right == null){
				return 1;
			}
			int min_val = Integer.MAX_VALUE;
			if(root.left != null){
				int left = minDepth(root.left);
				min_val = Math.min(left, min_val);
				
			}
			if(root.right != null){
				int right = minDepth(root.right);
				min_val = Math.min(right, min_val);
			}
			return min_val+1;
		}
    }
}