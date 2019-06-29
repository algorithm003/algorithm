/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        TreeNode *max = (p->val > q->val) ? p : q;
        TreeNode *min = (max == p) ? q : p;
        if (root->val > min->val && root->val < max->val)
            return root;
        if (root->val == min->val || root->val == max->val)
            return root;
        if (root->val > max->val)
            return lowestCommonAncestor(root->left, p, q);
        return lowestCommonAncestor(root->right, p, q);
    }
};
