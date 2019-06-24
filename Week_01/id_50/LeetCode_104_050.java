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
 * 二叉树的最大深度
 */
public class LeetCode_441_050 {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
	}

	public int maxDepth(TreeNode root) {
        if(root == null){
			return 0;
		}else{
			int left = maxDepth(root.left);
			int right = maxDepth(root.right);
			return Math.max(left, right)+1;
		}
    }
}