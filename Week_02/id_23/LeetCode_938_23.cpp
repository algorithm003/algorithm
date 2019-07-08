class Solution {
public:
    int rangeSumBST(TreeNode* root, int L, int R) {
        if (!root)
            return 0;
        int sum = 0;
        if (root->val > L)
            sum += rangeSumBST(root->left, L, R);
        if (root->val < R)
            sum += rangeSumBST(root->right, L, R);
        if (root->val >= L && root->val <= R)
            sum += root->val;
        return sum;
    }
};

class Solution {
public:
    int rangeSumBST(TreeNode* root, int L, int R) {
        if (!root)
            return 0;
        return ((root->val >= L && root->val <= R) ? root->val : 0) + rangeSumBST(root->left, L, R) + rangeSumBST(root->right, L, R);
    }
};

class Solution {
public:
    int rangeSumBST(TreeNode* root, int L, int R) {
        if (!root)
            return 0;
        return (root->val < L) ? rangeSumBST(root->right, L, R) : 
               (root->val > R) ? rangeSumBST(root->left, L, R) : root->val + rangeSumBST(root->left, L, R) + rangeSumBST(root->right, L, R);
    }
};
