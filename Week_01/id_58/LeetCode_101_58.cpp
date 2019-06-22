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
        if(!root)
            return true;
        return solve(root->left, root->right);
    }
    
    bool solve(TreeNode *left, TreeNode *right){
        if(!left && !right)
            return true;
        
        if(left && !right || !left && right || left->val != right->val)
            return false;
        
        return solve(left->left, right->right) && solve(left->right, right->left);
    }
};