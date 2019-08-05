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
    int rob(TreeNode* root) {
        int r = 0, u = 0;
        rob(root, r, u);
        return max(r, u);
    }
    
    void rob(TreeNode *root, int &r, int &u) {
        if (root == NULL)
            return;
        int rl = 0, ul = 0, rr = 0, ur = 0;
        rob(root->left, rl, ul);
        rob(root->right, rr, ur);
        r = root->val + ul + ur;
        u = max(rl, ul) + max(rr, ur);
    }
};
