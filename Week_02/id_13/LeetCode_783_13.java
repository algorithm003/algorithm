import java.lang.Integer;
/**
 给定一个二叉搜索树的根结点 root, 返回树中任意两节点的差的最小值。
 *
 *二叉搜索树中序遍历是升序遍历，树中任意两节点差的最小值则为相邻两节点的最小值
 * Created by hantao on 2019/6/29.
 */
public class LeetCode_783_13 {

    private static Integer res = Integer.MAX_VALUE,pre = null; // 保存节点的上一个节点

    public static int minDiffInBST(TreeNode root) {
        // 中序迭代，保证升序
        if (root.left != null)  minDiffInBST(root.left);
        if(pre != null) res = Math.min(res,Math.abs(root.val - pre));
        pre = root.val;
        if (root.right != null) minDiffInBST(root.right);

        return res;

    }

    public static void main(String[] args) throws InterruptedException {

        // 数组初始化为二叉树 [3,9,20,11,null,15,7,15,null,null,null,null,null,null]
        TreeNode rightLeaf = new TreeNode(20,new TreeNode(15,null,null),new TreeNode(7,null,null));
        TreeNode rightLeaf3 = new TreeNode(15,null,null);
        TreeNode leftLeaf2 = new TreeNode(11,rightLeaf3,null);
        TreeNode leftLeaf = new TreeNode(9,leftLeaf2,null);
        TreeNode root = new TreeNode(1,rightLeaf,leftLeaf);

        System.out.println(minDiffInBST(root));

    }
}
