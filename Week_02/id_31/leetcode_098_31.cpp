#include <iostream>

using namespace std;

/*
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。

假设一个二叉搜索树具有如下特征：

节点的左子树只包含小于当前节点的数。
节点的右子树只包含大于当前节点的数。
所有左子树和右子树自身必须也是二叉搜索树。
示例 1:

输入:
    2
   / \
  1   3
输出: true
示例 2:

输入:
    5
   / \
  1   4
     / \
    3   6
输出: false
解释: 输入为: [5,1,4,null,null,3,6]。
     根节点的值为 5 ，但是其右子节点值为 4 。
 */

/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};


//利用二叉搜索树的中序搜索特性，解决此问题。
class Solution {
public:
    bool ValidBST(TreeNode* root,TreeNode* &prev) {

        if (root==NULL)
            return true;

        //中序搜索
        if (root->left)
        {
            if (ValidBST(root->left,prev)== false)
            {
                return false;
            }
        }

        if (prev)
        {
            if ( (prev->val > root->val ) || (prev->val == root->val ) )
            {
                return false;
            }
        }
        prev = root;

        if (root->right)
        {
            return ValidBST(root->right,prev);
        }

        return true;
    }

    bool isValidBST(TreeNode* root) {
        TreeNode * prev = NULL;
        return ValidBST(root,prev);
    }
};

int main() {
    Solution mytest;
    TreeNode tsst1_root (2);
    TreeNode tsst1_level1_left (1);
    TreeNode tsst1_level1_right (3);
    TreeNode tsst1_level1_right_level2_left (3);
    TreeNode tsst1_level1_right_level2_right (6);

    tsst1_root.left = &tsst1_level1_left;
    tsst1_root.right = &tsst1_level1_right;
    //tsst1_level1_right.left = &tsst1_level1_right_level2_left;
    //tsst1_level1_right.right = &tsst1_level1_right_level2_right;

    bool result1 = mytest.isValidBST(&tsst1_root);
    cout<<result1<<endl;
    return 0;
}