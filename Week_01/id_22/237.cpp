/*
 * https://leetcode-cn.com/problems/binary-tree-paths/
 */

#include <iostream>
#include <vector>

using namespace std;

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

class Solution {
public:
    vector<string> binaryTreePaths(TreeNode* root) {
        dfs(root, "");
        return m_result;
    }

private:
    void dfs(TreeNode* root, string tag) {
        if (root == NULL) {
            return;
        }
        
        if(root->left == NULL && root->right == NULL) {
            m_result.push_back(tag);
        } 

        if(root->left != NULL) {
            dfs(root->left, tag + "->");
        }
            
        if(root->right != NULL) {
            dfs(root->right, tag + "->");
        }
    }

private:
    vector<string> m_result;
};

int main()
{
    return 0;
}