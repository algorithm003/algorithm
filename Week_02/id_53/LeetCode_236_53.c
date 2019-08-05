/**
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * 
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * 
 * 例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]
 * 
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出: 3
 * 解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */


/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 */

int dfs(struct TreeNode* root, struct TreeNode* p, struct TreeNode* q) {
    int n = 0;
    if ( root->left == NULL && root->right == NULL && 
           root->val != p->val && root->val != q->val)
              return 0; 
    if ( root->val == p->val || root->val == q->val ) n = 1;
    if ( root->left ) n += dfs(root->left, p, q);
    if ( n == 2) return 2;
    if ( root->right ) n += dfs(root->right, p, q);
    return n;
}
struct TreeNode* lowestCommonAncestor(struct TreeNode* root, struct TreeNode* p, struct TreeNode* q) {
    int n = 0, m = 0;
    if( root == q || root == p ) return root;
    if ( root->left ) n = dfs(root->left, p, q);
    if ( root->right) m = dfs(root->right, p, q);
    if(n == m && n == 1)
        return root;
    else if ( n == 2 )
        return lowestCommonAncestor(root->left, p, q);
    else if ( m == 2)
        return lowestCommonAncestor(root->right, p, q);
    else
        return NULL;
}
