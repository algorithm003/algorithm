#include <iostream>
#include <string>
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
	void help(TreeNode* root, vector<string> &result, string str)
	{
		if (root == NULL)
		{
			return;
		}

		if (str.empty())
		{
			str += to_string(root->val);
		}
		else
		{
			str += "->" + to_string(root->val);
		}

		if ((!root->left) && (!root->right))
		{
			result.push_back(str);
			return;
		}

		help(root->left, result, str);
		help(root->right, result, str);
	}

	vector<string> binaryTreePaths(TreeNode* root) {
		vector<string> res;
		string str;
		help(root, res, str);
		return res;
	}
};