/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */

/*
// DFS
class Solution {
public:
    int maxDepth(TreeNode* root) {
        if (!root) {
            return 0;
        }
        int max_left = maxDepth(root->left) + 1;
        int max_right = maxDepth(root->right) + 1;
        return max_left > max_right ? max_left : max_right;
    }
};
*/

// BFS
class Solution {
public:
    int maxDepth(TreeNode* root) {
        if (!root) {
            return 0;
        }
        int depth = 0;
        int count = 0;
        queue<TreeNode *> q;
        q.push(root);
        while(!q.empty()) {
            count = q.size();
            while(count > 0) {
                count--;
                TreeNode *node = q.front();
                q.pop();
                if (node->left) {
                    q.push(node->left);
                }
                if (node->right) {
                    q.push(node->right);
                }
            }
            depth++;
        }
        return depth;
    }
};