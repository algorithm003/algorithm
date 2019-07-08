/**
 * @author jinjw
 * @date 2019/7/7
 * @description 班上有 N 名学生。其中有些人是朋友，有些则不是。
 * 他们的友谊具有是传递性。如果已知 A 是 B 的朋友，B 是 C 的朋友，那么我们可以认为 A 也是 C 的朋友。
 * 所谓的朋友圈，是指所有朋友的集合。
 * 深度优先搜索 DFS
 */
public class LeetCode_547_34 {
    class Solution {
        public int findCircleNum(int[][] M) {
            int length = M.length;
            int count = 0;      //统计朋友圈个数
            boolean[] flag = new boolean[length];
            for (int i = 0; i < length; i++) {
                if (flag[i] == false) {
                    DFS(i, M, flag);
                    count++;
                }
            }
            return count;
        }

        public void DFS(int i, int[][] M, boolean[] flag) {
            flag[i] = true;
            for (int j = 0; j < M[i].length; j++) {
                if (flag[j] == false && M[i][j] == 1) {
                    DFS(j, M, flag);
                }
            }
        }
    }
}
