#include <iostream>


using namespace std;

struct TreeNode {
     int val;
     TreeNode *left;
 TreeNode *right;
     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};
namespace vesion_1
{
	class Solution {
	public:
		bool Symmetric(TreeNode* left, TreeNode* right)
		{
			if ((!left) && (!right))
				return true;

			if ((left&&right) && ((left->val) == (right->val)))
			{
				return (Symmetric(left->left, right->right)) && (Symmetric(left->right, right->left));
			}
			else
			{
				return false;
			}

			return false;
		}

		bool isSymmetric(TreeNode* root) {
			return Symmetric(root, root);
		}
	};
}
