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
        if (root == NULL)
            return 0;
        if (root->left != NULL)
            minDiffInBST(root->left);
        if (prev > 0)
            minDiff = min(minDiff, root->val - prev);
        prev = root->val;
        if (root->right != NULL)
            minDiffInBST(root->right);
        return minDiff;
    }
private:
    int prev = -1;
    int minDiff = INT_MAX;
};
