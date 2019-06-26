class Solution {
public:
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        // dfs
        if (root == NULL)
            return NULL;
        vector<TreeNode*> ppath = {root};
        vector<TreeNode*> qpath = {root};
        dfs(root, ppath, p);
        dfs(root, qpath, q);
        TreeNode *node = NULL;
        for (int i = 0; i < ppath.size() && i < qpath.size(); ++i) {
            if (ppath[i] == qpath[i]) {
                node = ppath[i];
                continue;
            }
            break;
        }

        return node;
    }

    TreeNode* dfs(TreeNode *root, vector<TreeNode*> &path, TreeNode* target) {
        if (root == target) {
            return root;
        }

        if (root == NULL) {
            return NULL;
        }

        if (root->left != NULL) {
            path.push_back(root->left);
            TreeNode *res = dfs(root->left, path, target);
            if (res)
                return res;
            path.pop_back();
        }
        if (root->right != NULL) {
            path.push_back(root->right);
            TreeNode *res = dfs(root->right, path, target);
            if (res)
                return res;
            path.pop_back();
        }

        return NULL;
    }
};


// 代码冗长，可以进一步简化代码