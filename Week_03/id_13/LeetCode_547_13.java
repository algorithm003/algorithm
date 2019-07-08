/**
 * @Auther hantao on 2019/7/7.
 * @Date 2019/7/7 14:25
 * @Description
 */
public class LeetCode_547_13 {


    public int findCircleNum(int[][] m) {
        // 记录访问到的person
        boolean[] visited = new boolean[m.length];
        // 记录朋友圈总数
        int count = 0;
        // n*n 矩阵对称。根据矩阵的长度可以遍历每一个人
        for (int i=0;i< m.length;i++){
            if (!visited[i]){
                dfs(m,visited,i);
                count++;
            }
        }

        return count;

    }

    /**
     * 从person开始递归查找，只要找到一个人是朋友关系，且该朋友未存入已访问数组中，则从该朋友继续遍历且将该该朋友访问已访问数组。按照DFS模式遍历完所有人。
     * 如果一个人已经被访问，说明此人已存在于之前被访问过的朋友圈，故没有必要再被访问。
     * @param m         矩阵
     * @param visited   已访问的个人
     * @param person    开始访问的个人
     */
    private void dfs(int[][] m, boolean[] visited,int person) {

        for (int other = 0;other < m.length;other++){

            if (m[person][other] == 1 && !visited[other]){
                visited[other] = true;
                dfs(m,visited,other);
            }
        }
    }


    public static void main(String[] args){

        int[][] a = {{1,1,0},{1,1,0},{0,0,1}};
        System.out.println(new LeetCode_547_13().findCircleNum(a));

    }
}
