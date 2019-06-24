class Solution {
public:
    int minDiffInBST(TreeNode* root) {
        vector<int> nodes;
        inorder(nodes, root);
        if (nodes.size() <= 1)
            return 0;
        
        int minDiff = abs(nodes[0]-nodes[1]);
        for (int i = 1; i < nodes.size()-1; ++i) {
            int diff = abs(nodes[i] - nodes[i+1]);
            minDiff = (minDiff < diff) ? minDiff : diff;
        }
        
        return minDiff;
    }
    
    void inorder(vector<int> &nodes, TreeNode *root) {
        if (root == NULL)
            return;
        if (root->left != NULL)
            inorder(nodes, root->left);
        nodes.push_back(root->val);
        if (root->right != NULL)
            inorder(nodes, root->right);
    }
};
