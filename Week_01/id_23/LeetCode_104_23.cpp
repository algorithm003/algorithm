class Solution {
public:
    int maxDepth(TreeNode* root) {
        if (root == NULL)
            return 0;
        
        deque<TreeNode*> deq;
        deq.push_back(root);
        int level = 0;
        while (!deq.empty()) {
            int deqSize = deq.size();
            
            for (int i = 0; i < deqSize; ++i) {
                TreeNode *node = deq.front();
                deq.pop_front();
                if (node->left != NULL)
                    deq.push_back(node->left);
                if (node->right != NULL)
                    deq.push_back(node->right);
            }
            
            ++level;
        }
        
        return level;
    }
};
