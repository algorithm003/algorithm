#include <iostream>
#include <vector>

using namespace std;

/*
 * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都围成一圈，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。

给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。

示例 1:

输入: [2,3,2]
输出: 3
解释: 你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
示例 2:

输入: [1,2,3,1]
输出: 4
解释: 你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
     偷窃到的最高金额 = 1 + 3 = 4 。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/house-robber-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * */

class Solution {
public:
    int rob(vector<int>& nums) {
        //不偷最后一个
        int cur1 = 0;
        int prev1 = 0;

        if (nums.empty())
            return 0;

        if (nums.size()==1)
            return nums[0];

        //dp方程
        for (int i = 0; i < nums.size()-1; ++i) {
            //记录当前偷的值
            int tmp = cur1;
            //
            cur1 = max(tmp,prev1+nums[i]);
            //记录前一次偷的值
            prev1 = tmp;
        }


        //不偷第一个。
        int cur2 = 0;
        int prev2 = 0;

        //dp方程
        for (int i = 1; i < nums.size(); ++i) {
            //记录当前偷的值
            int tmp = cur2;
            //
            cur2 = max(tmp,prev2+nums[i]);
            //记录前一次偷的值
            prev2 = tmp;
        }

        //不偷第一个的结果与不偷最后一个的结果的最大值
        return max(cur2,cur1);
    }
};

int main() {
    Solution mytest;
    vector<int> test1{2,3,2};
    cout<<mytest.rob(test1)<<endl;
    vector<int> test2{1,2,3,1};
    cout<<mytest.rob(test2)<<endl;

    vector<int> test3{1};
    cout<<mytest.rob(test3)<<endl;

    return 0;
}