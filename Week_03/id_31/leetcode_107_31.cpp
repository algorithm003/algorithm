#include <iostream>
#include <vector>
#include <iterator>
#include <algorithm>
#include <functional>

using namespace std;


/*
给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）

例如：
给定二叉树 [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
返回其自底向上的层次遍历为：

[
  [15,7],
  [9,20],
  [3]
]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */


struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

class Solution {
public:

    void LevelSearch (TreeNode* root, vector<vector<int > > &res, int n_level)
    {
        if (root==NULL)
            return;

        if (res.size() < n_level){
            vector<int> tmp;
            tmp.push_back(root->val);
            res.insert(res.begin(),tmp);
        } else{
            res[res.size() - n_level].push_back(root->val);
        }
        LevelSearch(root->left,res,n_level+1);
        LevelSearch(root->right,res,n_level+1);
    }

    vector<vector<int> > levelOrderBottom(TreeNode* root) {
        vector<vector<int > > result;
        int level = 1;
        LevelSearch(root,result,level);
        return result;
    }
};


int main() {
    Solution mytest;
    TreeNode tsst1_root (3);
    TreeNode tsst1_level1_left (9);
    TreeNode tsst1_level1_right (20);
    TreeNode tsst1_level1_right_level2_left (15);
    TreeNode tsst1_level1_right_level2_right (7);

    tsst1_root.left = &tsst1_level1_left;
    tsst1_root.right = &tsst1_level1_right;
    tsst1_level1_right.left = &tsst1_level1_right_level2_left;
    tsst1_level1_right.right = &tsst1_level1_right_level2_right;


    vector<vector<int> > result1 = mytest.levelOrderBottom(&tsst1_root);

    vector<vector<int> >::iterator start_result = result1.begin();
    vector<vector<int> >::iterator end_result = result1.end();

    for (;start_result != end_result;start_result++){
        cout<<"[";
        copy((*start_result).begin(),(*start_result).end(),ostream_iterator<int>(cout,","));
        cout<<"]"<<endl;
    }

    return 0;
}