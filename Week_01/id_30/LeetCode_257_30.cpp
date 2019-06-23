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
    vector<string> binaryTreePaths(TreeNode* root) {
        vector<string> paths;
        if (root == nullptr) {
            return paths;
        }
        findPath(paths, "", root);
        return paths;
    }
    
    void findPath(vector<string> & paths, string path, TreeNode * node) {
        stringstream ss;
        ss << node->val;
        path = path == "" ? ss.str() : path + "->" + ss.str();
        if (node->left == nullptr && node->right == nullptr) {
            paths.push_back(path);
            return;
        }
        if (node->left)
            findPath(paths, path, node->left);
        if (node->right)
            findPath(paths, path, node->right);
    }
};