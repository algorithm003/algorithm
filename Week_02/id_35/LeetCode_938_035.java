package week2;

/**
 * @ author: Suhb
 * @ date: 2019/6/26 10:13
 * @ description: 938. 二叉搜索树的范围和
 */
public class LeetCode_938_035 {
    /*给定二叉搜索树的根结点 root，返回 L 和 R（含）之间的所有结点的值的和。
    二叉搜索树保证具有唯一的值。
    示例 1：
        输入：root = [10,5,15,3,7,null,18], L = 7, R = 15
        输出：32
    示例 2：
        输入：root = [10,5,15,3,7,13,18,1,null,6], L = 6, R = 10
        输出：23
    提示：
        树中的结点数量最多为 10000 个。
        最终的答案保证小于 2^31。*/
    private int rangeSumBST(TreeNode root, int L, int R) {
        if (root == null) {
            return 0;
        }
        /*if (root.val < L) {
            return rangeSumBST(root.right, L, R);
        } else if (root.val > R) {
            return rangeSumBST(root.left, L, R);
        } else {
            return root.val + rangeSumBST(root.left, L, R) + rangeSumBST(root.right, L, R);
        }*/
        return root.val < L ? rangeSumBST(root.right, L, R) :   // 当前根节点值小于最小边界，那就继续判断右子树，因为右子树总是比根节点的值大的
                root.val > R ? rangeSumBST(root.left, L, R) :   // 当前根节点值大小最大边界，那就继续判断左子树，因为左子树总是比根节点的值小的
                        root.val + rangeSumBST(root.left, L, R) + rangeSumBST(root.right, L, R);    // 如果根节点在最小最大边界范围内，那就加上当前值，再下钻
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        LeetCode_938_035 leetCode_938_035 = new LeetCode_938_035();
        LeetCode_938_035.TreeNode root = leetCode_938_035.new TreeNode(10);
        LeetCode_938_035.TreeNode rootLeft = leetCode_938_035.new TreeNode(5);
        LeetCode_938_035.TreeNode rootRight = leetCode_938_035.new TreeNode(15);
        root.left = rootLeft;
        root.right = rootRight;
        LeetCode_938_035.TreeNode root1Left = leetCode_938_035.new TreeNode(3);
        LeetCode_938_035.TreeNode root1Right = leetCode_938_035.new TreeNode(7);
        rootLeft.left = root1Left;
        rootLeft.right = root1Right;
        LeetCode_938_035.TreeNode root1_2Right = leetCode_938_035.new TreeNode(18);
        rootRight.right = root1_2Right;
        int result = leetCode_938_035.rangeSumBST(root, 7, 15);
        System.out.println(result);
    }
}
