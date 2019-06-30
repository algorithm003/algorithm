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
    bool isSymmetric(TreeNode* root) {
        return _isMirror(root, root);
    }
private:
    bool _isMirror(TreeNode* r1, TreeNode* r2) {
        if (!r1 && !r2) return true;
        if (!r1 || !r2) return false;
        return (r1->val == r2->val) 
            && _isMirror(r1->left, r2->right) 
            && _isMirror(r1->right, r2->left);
    }
};
