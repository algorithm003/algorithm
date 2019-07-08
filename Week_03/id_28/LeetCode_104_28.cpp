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
    int maxDepth(TreeNode* root) {
        return Dfs(0, root);
    }
private:
    int Dfs(int level, TreeNode *node) {
        return node ? max(Dfs(level + 1, node->left), Dfs(level + 1, node->right)) : level;
    }
};
