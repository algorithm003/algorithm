package com.panguang.cooltea.pglib;

/*
*
*        70. 爬楼梯
*
*        假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
*
*        每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
*
*        注意：给定 n 是一个正整数。
*
*        https://leetcode-cn.com/problems/climbing-stairs/
*
*        学号：020
*
*/


public class LeetCode_70_20 {

    //方法一：递归，提交LeetCode超时……
    //时间复杂度：O(2^n)
    public int climbStairs1(int n) {
        return climb_Stairs(0, n);
    }
    private int climb_Stairs(int i, int n){
        if (i > n) return 0;
        if (i == n) return 1;
        return climb_Stairs(i + 1, n) + climb_Stairs(i + 2, n);
    }


    //方法二： DP
    //时间复杂度：O(n)
    //空间复杂度：O(n)
    public int climbStairs2(int n) {
        if (n == 1) return 1;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++){
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    //方法三： 循环
    //时间复杂度：O(n)
    //空间复杂度：O(1)
    public int climbStairs(int n) {
        if (n == 1) return 1;
        int first = 1;
        int second = 2;
        for (int i = 3; i <= n; i++){
            int third = first + second;
            first = second;
            second = third;
        }
        return second;
    }


}
