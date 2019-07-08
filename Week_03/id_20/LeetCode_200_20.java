package com.panguang.cooltea.pglib;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/*
 *      200. 岛屿数量
 *
 *      给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。
 *
 *      链接：https://leetcode-cn.com/problems/number-of-islands/
 *
 *      学号：020
 *
 * */

public class LeetCode_200_20 {


    //方法一：Flood fill
    //时间复杂度：O(n²)
    public int numIslands(char[][] grid) {
        int count = 0;
        if (grid.length == 0 ) return 0;
        for (int i = 0; i < grid.length; i++){
            int m = grid[i].length;
            for (int j = 0; j < m; j ++){
                if (grid[i][j] == '1'){
                    DFSFill(grid, i, j);
                    // BFSFill(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    // DFS
    private void DFSFill(char[][] grid, int i, int j){
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != '1') return;
        grid[i][j] = '0';
        DFSFill(grid, i - 1, j);
        DFSFill(grid, i + 1, j);
        DFSFill(grid, i, j - 1);
        DFSFill(grid, i, j + 1);
    }

    // BFS
    private void BFSFill(char[][] grid, int i, int j){
        grid[i][j] = '0';
        int n = grid.length;
        int m = grid[0].length;
        LinkedList<Integer> queue = new LinkedList<Integer>();
        int idx = i * m + j;
        queue.offer(idx);
        while (!queue.isEmpty()){
            idx = queue.poll();
            i = idx / m;
            j = idx % m;
            if (i > 0 && grid[i - 1][j] == '1'){
                queue.offer((i - 1) * m + j);
                grid[i - 1][j] = '0';
            }
            if (i < n - 1 && grid[i+1][j] == '1'){
                queue.offer((i + 1) * m + j);
                grid[i + 1][j] = '0';
            }
            if (j > 0 && grid[i][j - 1] == '1'){
                queue.offer(i  * m + j - 1);
                grid[i][j - 1] = '0';
            }
            if (j < m - 1 && grid[i][j + 1] == '1'){
                queue.offer(i  * m + j + 1);
                grid[i][j + 1] = '0';
            }
        }
    }


    //方法二：并查集
    //时间复杂度：O(n²)
    //空间复杂度：O(n)
    int[] roots;

    public int numIslands2(char[][] grid) {
        if (grid.length == 0) return 0;
        int m = grid.length, n = grid[0].length;
        roots = new int[m * n];
        Arrays.fill(roots, -1);
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (grid[i][j] == '1'){
                    roots[i * n + j] = i * n + j;
                    if (i > 0 && grid[i - 1][j] == '1') union(i * n + j, (i - 1) * n + j);
                    if (j > 0 && grid[i][j - 1] == '1') union(i * n +j, i * n +j - 1);
                }
            }
        }

        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < roots.length; i++){
            if (roots[i] != -1) set.add(find(roots[i]));
        }
        return set.size();
    }

    int find(int x){
        if (roots[x] == x) return x;
        roots[x] = find(roots[x]);
        return roots[x];
    }

    void union(int i, int j){
        int tempi = find(i);
        int tempj = find(j);
        roots[tempi] = roots[tempj];
    }

}
