package Week_03.id_37;

/**
 * 类描述：岛屿数量
 * 创建人： Sun YongMeng
 * 创建时间：2019/7/3 9:26
 * 修改人：  Sun YongMeng
 * 修改时间：2019/7/3 9:26
 * 修改备注：
 */
public class LeetCode_200_37 {

    /**
     * 给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。
     * 一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。
     * 你可以假设网格的四个边均被水包围。
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1'){
                    dfs(grid,i,j);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(char[][]grid,int i,int j){
        if (i < 0 || j< 0  || i >= grid.length || j >= grid[i].length){return;}
        if (grid[i][j] == '1'){
            grid[i][j] ='2';
            //前后上下
            dfs(grid, i + 1, j);
            dfs(grid, i - 1, j);
            dfs(grid, i, j + 1);
            dfs(grid, i, j - 1);
        }else{
            return;
        }
    }


}
