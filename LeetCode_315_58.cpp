class Solution {
public:
     struct Node{
        int val, smaller;
        Node *left, *right;
        Node(int v, int s) : val(v), smaller(s), left(NULL), right(NULL) {}
    };
        
    int insert(Node*& root, int val){
        if (!root)
            return (root = new Node(val, 0)), 0;
        if (root->val > val) 
            return root->smaller++, insert(root->left, val);
        
        return insert(root->right, val) + root->smaller + (root->val < val ? 1 : 0);
    }
        
    vector<int> countSmaller(vector<int>& nums){
        vector<int> res(nums.size());
        Node *root = NULL;
        for (int i = nums.size() - 1; i >= 0; --i){
            res[i] = insert(root, nums[i]);
        }
        return res;
    }
};