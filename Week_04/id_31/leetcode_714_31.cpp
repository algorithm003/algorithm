#include <iostream>
#include <vector>

using namespace std;



/*
 * 给定一个整数数组 prices，其中第 i 个元素代表了第 i 天的股票价格 ；非负整数 fee 代表了交易股票的手续费用。

你可以无限次地完成交易，但是你每次交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。

返回获得利润的最大值。

示例 1:

输入: prices = [1, 3, 2, 8, 4, 9], fee = 2
输出: 8
解释: 能够达到的最大利润:
在此处买入 prices[0] = 1
在此处卖出 prices[3] = 8
在此处买入 prices[4] = 4
在此处卖出 prices[5] = 9
总利润: ((8 - 1) - 2) + ((9 - 4) - 2) = 8.

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */

class Solution {
public:
    int maxProfit(vector<int>& prices, int fee) {

        if (prices.empty())
            return 0;

        //总利润
        int result = 0;
        //买入的时机
        int buy = prices[0];
        for (int i = 1; i <prices.size() ; ++i) {
            //如果股票价格，小于前一次买入价格。即买入
            if (prices[i] < buy){
                buy = prices[i];
            } else{
                //判断是否有利润。
                if (prices[i]-buy-fee>0){
                    //把利润加入结果。
                    result +=  prices[i] - buy  -fee;
                    //前一次的卖出价格。做入买入价格。
                    buy = prices[i] - fee;
                }
            }
        }
        //返回总利润
        return result;
    }
};

int main() {
    Solution mytest;
    vector<int> test1 {1, 3, 2, 8, 4, 9};
    cout<<mytest.maxProfit(test1,2)<<endl;
    return 0;
}