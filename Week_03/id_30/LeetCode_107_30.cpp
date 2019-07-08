/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */

// 思路，先找到最深的深度，初始化足够的数组，从根节点开始，填充对应的数组层。
class Solution {
public:
    vector<vector<int>> levelOrderBottom(TreeNode* root) {
        vector<vector<int>> ans;
        if (root == nullptr) {
            return ans;
        }
        int depth = findDepth(root);
        ans.resize(depth);
        bfs(root, ans, depth-1);
        return ans;
    }
    
    void bfs(TreeNode * root, vector<vector<int>> & vec, int level) {
        if (root == nullptr) {
            return;
        }
        vec[level].push_back(root->val);
        bfs(root->left, vec, level-1);
        bfs(root->right, vec, level-1);
    }
    int findDepth(TreeNode * root) {
        if (root == nullptr) {
            return 0;
        }
        return 1+max(findDepth(root->left), findDepth(root->right));
    }
};