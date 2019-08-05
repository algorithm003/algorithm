#include <iostream>
#include <vector>
using namespace std;
/*
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。

机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。

问总共有多少条不同的路径？



例如，上图是一个7 x 3 的网格。有多少可能的路径？

说明：m 和 n 的值均不超过 100。

示例 1:

输入: m = 3, n = 2
输出: 3
解释:
从左上角开始，总共有 3 条路径可以到达右下角。
1. 向右 -> 向右 -> 向下
2. 向右 -> 向下 -> 向右
3. 向下 -> 向右 -> 向右
示例 2:

输入: m = 7, n = 3
输出: 28

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/unique-paths
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */

class Solution {
public:
    int SolutionUniquePaths(int m, int n,vector<vector<int>>& memory) {

        //最后一行
        if (m==1){
            memory[m][n]=1;
            return 1;
        }

        //最后一列
        if (n==1){
            memory[m][n]=1;
            return 1;
        }

        //多余的条件。
        if ((m==0)&&(n==0)){
            memory[m][n]=0;
            return 0;
        }

        //dp方程
        //如果这项，没有被计算。则计算向下走一步和向右走一步的可能性之和。
        if (memory[m][n]==0)
            memory[m][n] = SolutionUniquePaths(m-1,n, memory)+ SolutionUniquePaths(m,n-1,memory);

        //返回计算结果。
        return memory[m][n];
    }

    int uniquePaths(int m, int n) {
        //临时存放计算dp方程的结果。
        vector<vector<int>> ivec(m+1, vector<int>(n+1, 0));
        //调用dp方程函数。
        return SolutionUniquePaths(m,n,ivec);
    }
};


int main() {
    Solution mytest;
    cout<<mytest.uniquePaths(3,2)<<endl;
    cout<<mytest.uniquePaths(7,3)<<endl;
    return 0;
}