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
    // 这两种做法空间复杂度都是O(1)，时间复杂度是O(n)，
    // 但是剪枝的方式可以筛掉不需要计算的分支，当数据量大的时候效率提升非常可观
    
    // bfs
    /*int rangeSumBST(TreeNode* root, int L, int R) {
        if (!root) 
            return 0;
        int sum = 0;
        if (root->val >= L && root->val <=R) {
            sum += root->val;
        }
        if (root->left) {
            sum += rangeSumBST(root->left, L, R);
        }
        if (root->right) {
            sum += rangeSumBST(root->right, L, R);
        }
        return sum;
    }
    */
    // 剪枝，值大于右值，只有左边合适； 值大于左值，只有右边合适；否则两边都合适
    int rangeSumBST(TreeNode* root, int L, int R) {
        if (!root) 
            return 0;
        
        if (root->val > R) {
            return rangeSumBST(root->left, L, R);
        } else if (root->val < L) {
            return rangeSumBST(root->right, L, R);
        } 
        return root->val + rangeSumBST(root->left, L, R) + rangeSumBST(root->right, L, R); 
    }
};

