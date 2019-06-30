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
        ostringstream out;
        serialize(root, out);
        return out.str();
    }

    // Decodes your encoded data to tree.
    TreeNode* deserialize(string data) {
        istringstream in(data);
        return deserialize(in);  
    }
    
    
    void serialize(TreeNode* node, ostringstream& out){
        if (node){
            out << node->val << ' ';
            serialize(node->left, out);
            serialize(node->right, out);
        } else {
            out << "#";
        }
    }
    
    TreeNode* deserialize(istringstream& in){
        string value;
        in >> value;
        
        if(value == "#")
            return NULL;
        TreeNode* root = new TreeNode(stoi(value));
        root->left = deserialize(in);
        root->right = deserialize(in);
        
        return root;
    }
    
};