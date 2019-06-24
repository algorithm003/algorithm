package Week_01.id_37;

import Week_01.id_37.bean.TreeNode;

/**
 * 类描述：
 * 创建人： Sun YongMeng
 * 创建时间：2019/6/20 14:05
 * 修改人：  Sun YongMeng
 * 修改时间：2019/6/20 14:05
 * 修改备注：
 */
public class LeetCode_104_37 {
    public int maxDepth(TreeNode root) {
        if (root == null){
            return 0;
        }else{
            int left = maxDepth(root.left);
            int right = maxDepth(root.right);
            return Math.max(left,right)+1;
        }
    }
}
