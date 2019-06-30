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
    int rangeSumBST(TreeNode* root, int L, int R) {
        int sum = 0;
        _inorder(root, L, R, sum);
        return sum;
    }
private:
    void _inorder(TreeNode* root, int L, int R, int& sum) {
        if (!root) return;
        if (root->val >= L) _inorder(root->left, L, R, sum);
        if ((root->val >= L) && (root->val <= R)) sum += root->val;
        if (root->val <= R) _inorder(root->right, L, R, sum);
    }
};
