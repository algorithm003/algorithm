#include <iostream>
#include <vector>

using namespace std;

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

//
class Solution {
public:
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        if ( (root==NULL) || (root==p) || (root==q) )
            return root;

        //后序遍历。来解决这个问题。
        //因为，后序遍历，根在最后面。

        TreeNode * left = NULL;
        TreeNode * right = NULL;
        //在范围内，统计累计值，搜左右子树
        if ((root->val >= p->val) && (root->val <= q->val))
        {
            left = lowestCommonAncestor(root->left, p, q);
            right = lowestCommonAncestor(root->right, p, q);
        }

        //利用二叉搜索树的性质。大于右值，搜左子树。
        if (root->val > q->val)
        {
            left = lowestCommonAncestor(root->left, p, q);
        }

        //利用二叉搜索树的性质。小于左值，搜右子树。
        if (root->val < p->val)
        {
            right = lowestCommonAncestor(root->right, p, q);
        }

        if (left==NULL)
        {
            //左空，则返回右子树。
            return right;
        }
        else if (right==NULL)
        {
            //左不空，右空，则返左子树
            return left;
        } else{
            //左右不空，则返回当前根结点。
            return root;
        }
    }
};


int main() {

    Solution mytest;
    TreeNode tsst1_root (3);
    TreeNode tsst1_level1_left (5);
    TreeNode tsst1_level1_right (1);
    TreeNode tsst1_level1_left_level2_left (6);
    TreeNode tsst1_level1_left_level2_right (2);
    TreeNode tsst1_level1_right_level2_left (0);
    TreeNode tsst1_level1_right_level2_right (8);
    TreeNode tsst1_level3_left (7);
    TreeNode tsst1_level3_right (4);

    tsst1_root.left = &tsst1_level1_left;
    tsst1_root.right = &tsst1_level1_right;
    tsst1_level1_left.left = &tsst1_level1_left_level2_left;
    tsst1_level1_left.right = &tsst1_level1_left_level2_right;
    tsst1_level1_right.left = &tsst1_level1_right_level2_left;
    tsst1_level1_right.right = &tsst1_level1_right_level2_right;
    tsst1_level1_left_level2_right.left = &tsst1_level3_left;
    tsst1_level1_left_level2_right.right = &tsst1_level3_right;


    TreeNode * result1 = mytest.lowestCommonAncestor(&tsst1_root,&tsst1_level1_left,&tsst1_level1_right);
    cout << result1->val <<endl;

    TreeNode * result2 = mytest.lowestCommonAncestor(&tsst1_root,&tsst1_level1_left,&tsst1_level3_right);
    cout << result2->val <<endl;

    return 0;
}