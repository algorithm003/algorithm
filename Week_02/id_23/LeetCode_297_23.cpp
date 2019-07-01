/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Codec {
public:

    // Encodes a tree to a single string.
    string serialize(TreeNode* root) {
        if (!root) return "#";
        return to_string(root->val) + "," + serialize(root->left) + "," + serialize(root->right);
    }

    // Decodes your encoded data to tree.
    TreeNode* deserialize(string data) {
        return _deserialize(data);
    }
    
private:
    TreeNode* _deserialize(string &data) {
        if (data[0] == '#') {
            if (data.size() > 1)
                data = data.substr(2);
            return NULL;
        }
        int i = 0;
        while (data[i] != ',') {
            ++i;
        }
        TreeNode *root = new TreeNode(stoi(data.substr(0, i)));
        data = data.substr(i+1);
        root->left = _deserialize(data);
        root->right = _deserialize(data);
        return root;
    }
};

// Your Codec object will be instantiated and called as such:
// Codec codec;
// codec.deserialize(codec.serialize(root));
