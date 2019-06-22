class Solution {
public:
    int minDepth(TreeNode* root) {
        if (root == NULL)
            return 0;
        deque<TreeNode*> deq;
        deq.push_back(root);
        int currLevel = 0;
        while (!deq.empty()) {
            int deqSize = deq.size();
            ++ currLevel;
            
            for (int i = 0; i < deqSize; ++i) {
                TreeNode *node = deq.front();
                deq.pop_front();
                
                // leaf node
                if (node->left == NULL && node->right == NULL) {
                    return currLevel;
                }
                
                if (node->left != NULL)
                    deq.push_back(node->left);
                if (node->right != NULL)
                    deq.push_back(node->right);
            }
        }
        
        return -1; // never goes here
    }
};
