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
    int minD(TreeNode* root) {
        if(root==NULL)
            return 0;
        
        return 1+ min(minD(root->left),minD(root->right));
    }
    
    int minDepth(TreeNode* root) {
        if(root==NULL)
            return 0;
        if(root->left != NULL && root->right!=NULL)
            return 1+ min(minDepth(root->left),minDepth(root->right));
        else if(root->left != NULL)
            return 1+minDepth(root->left);
        else
            return 1+minDepth(root->right);

            
    }
    
};