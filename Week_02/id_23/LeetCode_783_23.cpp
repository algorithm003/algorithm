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
    int minDiffInBST(TreeNode* root) {
        int prev = -1, mindiff = INT_MAX;
        inorder(root, prev, mindiff);
        return mindiff;
    }
    
    void inorder(TreeNode *root, int &prev, int &mindiff) {
        if (root == NULL)
            return;
        if (root->left != NULL)
            inorder(root->left, prev, mindiff);
        if (prev > 0)
            mindiff = min(mindiff, root->val - prev);
        prev = root->val;
        if (root->right != NULL)
            inorder(root->right, prev, mindiff);
    }
};
