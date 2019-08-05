#include <iostream>
#include <vector>
#include <iterator>
#include <algorithm>

using namespace std;

/*
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。

说明：解集不能包含重复的子集。

示例:

输入: nums = [1,2,3]
输出:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/subsets
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */

class Solution {
public:
    void help(vector<int>& nums,vector<vector<int>>& ans,vector<int> tmp,int pos){
        //存起子集的结果。
        ans.push_back(tmp);

        for(int i = pos;i<nums.size();i++){
            tmp.push_back(nums[i]);
            help(nums,ans,tmp,i+1);
            //此句非常重要。回溯法的精髓。
            tmp.pop_back();
        }
    }

    vector<vector<int>> subsets(vector<int>& nums) {
        vector<vector<int>> ans;
        vector<int> tmp;
        help(nums,ans,tmp,0);
        return ans;
    }
};


int main() {
    Solution mytest;
    vector<int> test1 ={1,2,3};
    vector<vector<int>> result1 = mytest.subsets(test1);

    for (auto start= result1.begin();start!=result1.end();start++){
        copy((*start).begin(),(*start).end(),ostream_iterator<int>(cout,","));
        cout<<endl;
    }

    return 0;
}