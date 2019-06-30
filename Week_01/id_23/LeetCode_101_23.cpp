class Solution {
public:
    bool isSymmetric(TreeNode* root) {
        if (root == NULL)
            return true;
        return isSymm(root->left, root->right);
    }
    
    bool isSymm(TreeNode *left, TreeNode *right) {
        if (left == NULL && right == NULL)
            return true;
        if (left == NULL || right == NULL)
            return false;
        if (left->val != right->val)
            return false;
        return isSymm(left->left, right->right) && 
               isSymm(left->right, right->left);
    }
};
