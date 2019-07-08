#include <iostream>
#include <vector>

using namespace std;


/*
 * 给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。

例如，给定一个 3叉树

                            1
                        /   |   \
                      3     2    4
                   /   \
                   5    6


 返回其层序遍历:

[
     [1],
     [3,2,4],
     [5,6]
]
 *
 * */




class Node {
public:
    int val;
    vector<Node*> children;

    Node() {}

    Node(int _val, vector<Node*> _children) {
        val = _val;
        children = _children;
    }
};

class Solution {
public:
    void LevelSearch (Node* root, vector<vector<int > > &res, int n_level) {
        if (root==NULL)
            return;

        if (res.size() < n_level) {
            vector<int> tmp;
            res.push_back(tmp);
        }

        res[n_level-1].push_back(root->val);

        for (Node* chlid : root->children) {
            LevelSearch(chlid,res,n_level+1);
        }
    }

    vector<vector<int>> levelOrder(Node* root) {
        vector<vector<int > > result;
        int level = 1;
        LevelSearch(root,result,level);
        return result;
    }
};

int main() {
    Solution mytest;
    //没有写测试用例，这个写测试用例，太烦了。直接在leetcode上面跑。是通过leetcode的所有用例的。
    //具体是参考我的leetcode 102。稍稍改一下。
    return 0;
}