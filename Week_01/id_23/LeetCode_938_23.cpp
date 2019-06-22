class Solution {
public:
    int rangeSumBST(TreeNode* root, int L, int R) {
        vector<int> nodes;
        inorder(nodes, root);
        
        int sum = 0;
        for (int i = 0; i < nodes.size(); ++i) {
            if (nodes[i] > R)
                break;
            if (nodes[i] < L)
                continue;
            sum += nodes[i];
        }
        
        return sum;
    }
    
    void inorder(vector<int> &nodes, TreeNode* root) {
        if (root == NULL)
            return;
        if (root->left != NULL)
            inorder(nodes, root->left);
        nodes.push_back(root->val);
        if (root->right != NULL)
            inorder(nodes, root->right);
    }
};
