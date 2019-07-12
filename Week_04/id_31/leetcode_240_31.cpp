#include <iostream>
#include <vector>

using namespace std;

/*
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target。该矩阵具有以下特性：

每行的元素从左到右升序排列。
每列的元素从上到下升序排列。
示例:

现有矩阵 matrix 如下：

[
  [1,   4,  7, 11, 15],
  [2,   5,  8, 12, 19],
  [3,   6,  9, 16, 22],
  [10, 13, 14, 17, 24],
  [18, 21, 23, 26, 30]
]
给定 target = 5，返回 true。

给定 target = 20，返回 false。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/search-a-2d-matrix-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */
namespace version_1
{
    class Solution {
    public:
        //二分搜索
        bool binarySearch(vector<int>& v,int target){
            int low = 0;
            int high = v.size()-1;
            int mid  = (low+high)/2;

            if (v.empty()){
                return false;
            }

            while (low<=high){
                if (v[mid]==target){
                    return true;
                } else if (v[mid] <target){
                    low = mid +1;
                    mid  = (low+high)/2;
                } else{
                    high = mid-1;
                    mid  = (low+high)/2;
                }
            }
            return false;
        }

        bool searchMatrix(vector<vector<int>>& matrix, int target) {
            //判空
            if (matrix.empty()){
                return false;
            }

            for (vector<int>& v : matrix){
                //判空
                if (v.empty()){
                    continue;
                }

                //在所限范围内，搜索。
                if ((v[0]<= target) && (v[v.size()-1]>=target)){
                    //由于数组内的元素，是已经排序好的。所以可以用二分搜索。
                    //如果是搜到，直接返回true。
                    if (binarySearch(v,target)){
                        return true;
                    }
                }
            }
            return false;
        }
    };
}

namespace version_2{
    class Solution {
    public:
        bool searchMatrix(vector<vector<int>>& matrix, int target) {
            if (matrix.empty()){
                return false;
            }

            if (matrix[0].empty()){
                return false;
            }

            //行数
            int m = matrix.size() -1;
            //列数
            int n = matrix[0].size() -1;

            //列为0
            int col = 0;
            //行为最后一行
            int row = m;

            while ((col<=n)&&(row>=0)){
                if (matrix[row][col]==target){
                    //如果找到，则返回true
                    return true;
                } else if (matrix[row][col]>target){
                    //当前行的行列比目标值，还大的话，则搜索上一行。
                    row--;
                } else {
                    //当前行的行列比目标值，还小的话，则搜索下一列。
                    col++;
                }
            }
            //如果超过行的下标或列的下标，则是没有找到
            return false;
        }
    };
}

using namespace version_2;

int main() {
    Solution mytest;
    vector<vector<int>> test1 = {
            {1,   4,  7, 11, 15},
            {2,   5,  8, 12, 19},
            {3,   6,  9, 16, 22},
            {10, 13, 14, 17, 24},
            {18, 21, 23, 26, 30}
    };

    cout<<mytest.searchMatrix(test1,5)<<endl;
    cout<<mytest.searchMatrix(test1,20)<<endl;
    return 0;
}