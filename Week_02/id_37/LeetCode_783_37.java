package Week_02.id_37;

/**
 * 类描述：
 * 创建人： Sun YongMeng
 * 创建时间：2019/6/28 10:52
 * 修改人：  Sun YongMeng
 * 修改时间：2019/6/28 10:52
 * 修改备注：
 */
public class LeetCode_783_37 {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * 二叉搜索树的中序遍历是升序排列,
     * 因此只需要依次对比相邻两个数的最小差即可
     * ps:在做题当中,关于中间变量第一次赋值时思考了很久,
     * 最终给出的如下判断.不知是否妥当
     */
    int min = Integer.MAX_VALUE;
    int pre;
    int next = Integer.MAX_VALUE;
    public int minDiffInBST(TreeNode root) {
        if(root == null){ return min; }
        if(root.left != null){ minDiffInBST(root.left); }
        if (next != Integer.MAX_VALUE){
            pre = next;
            next = root.val;
            min = Math.min(min, next - pre);
        }
        next = root.val;
        if(root.right != null){ minDiffInBST(root.right); }
        return min;
    }

}
