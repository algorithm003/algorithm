/**
 * 257. 二叉树的所有路径
 * https://leetcode-cn.com/problems/binary-tree-paths/solution/er-cha-shu-de-suo-you-lu-jing-by-leetcode/
 */
class Solution {
    private List<String> al = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        String path="";
        dfs(root, path);
        return al;
    }

    public void dfs(TreeNode root,String path){
        if(root==null) return;
        path+=root.val;
        if(root.left==null&&root.right==null){
            al.add(path);
        }else{
            path+="->";
        dfs(root.left,path);
        dfs(root.right, path);
        }
    }
}