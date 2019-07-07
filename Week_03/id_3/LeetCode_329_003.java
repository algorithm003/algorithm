package com.zmm;

/**
 给定一个整数矩阵，找出最长递增路径的长度。

 对于每个单元格，你可以往上，下，左，右四个方向移动。 你不能在对角线方向上移动或移动到边界外（即不允许环绕）。

 示例 1:

 输入: nums =
 [
 [9,9,4],
 [6,6,8],
 [2,1,1]
 ]
 输出: 4
 解释: 最长递增路径为 [1, 2, 6, 9]。
 示例 2:

 输入: nums =
 [
 [3,4,5],
 [3,2,6],
 [2,2,1]
 ]
 输出: 4
 解释: 最长递增路径是 [3, 4, 5, 6]。注意不允许在对角线方向上移动。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/longest-increasing-path-in-a-matrix
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_329_003 {

     int m = 1;
     int n = 1 ;
     int ans = 1;
     int memo[][];
    public  int longestIncreasingPath(int[][] matrix){

        m = matrix.length;
        n = matrix[0].length;
        memo = new int[m][n];
        for (int i = 0; i < m ; i++){
            for (int j = 0 ; j < n ; j++){
                ans = Math.max(ans,dfs(matrix,i,j,Integer.MIN_VALUE));
            }
        }
        return ans;
    }

    public  int dfs(int[][] matrix, int i, int j, int prev) {
        if (i < 0 || j < 0 || i == m || j == n || prev >= matrix[i][j]) return 0;
        if (memo[i][j] > 0 ) return memo[i][j];

        int count = 1 ;
        //x轴移动
        count = Math.max(count,dfs(matrix,i+1,j,matrix[i][j]) + 1);
        //y轴移动
        count = Math.max(count,dfs(matrix,i,j+1,matrix[i][j]) + 1);
        count = Math.max(count,dfs(matrix,i-1,j,matrix[i][j]) + 1);
        count = Math.max(count,dfs(matrix,i,j-1,matrix[i][j]) + 1);
        memo[i][j] = count;
        return count;
    }
}
