class Solution {
public:
    bool isValidBST(TreeNode* root) {
        return isValidBST(root, NULL, NULL);
    }
    
    bool isValidBST(TreeNode *root, TreeNode *min, TreeNode *max) {
        if (!root)
            return true;
        if ((min && root->val <= min->val) || (max && root->val >= max->val))
            return false;
        return isValidBST(root->left, min, root) && isValidBST(root->right, root, max);
    }
};

// inorder
class Solution {
public:
    bool isValidBST(TreeNode* root) {
        if (!root)
            return true;
        if (root->left != NULL && !isValidBST(root->left))
            return false;
        if (prev != NULL && prev->val >= root->val)
            return false;
        prev = root;
        if (root->right != NULL && !isValidBST(root->right))
            return false;
        return true;
    }
private:
    TreeNode *prev = NULL;
};

