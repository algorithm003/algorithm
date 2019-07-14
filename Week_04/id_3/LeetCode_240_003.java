package com.zzm.leetCode;

/**
 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target。该矩阵具有以下特性：

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
 */
public class LeetCode_240_003 {
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int i = 0 ; i < matrix.length ; i ++){
            if (matrix[i].length > 0 && matrix[i][0] <= target &&
                    target <= matrix[i][matrix[i].length -1]){
                if (bSearch(matrix[i],target)){
                    return true;
                }
            }
        }
        return false;
    }

    public   boolean bSearch(int[] n,int target){
        int start = 0;
        int end = n.length - 1;
        while (start <= end){
            int mid = start + (end-start)/2;
            if (n[mid] > target){
                end = mid - 1;
            }else if(n[mid] < target){
                start = mid + 1;
            }else {
                return true;
            }
        }
        return false;
    }
}
