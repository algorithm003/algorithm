package week3;

/**
 * @ author: Suhb
 * @ date: 2019/7/1 17:31
 * @ description: 深度优先：547. 朋友圈
 */
public class LeetCode_547_035 {
    /*班上有 N 名学生。其中有些人是朋友，有些则不是。他们的友谊具有是传递性。如果已知 A 是 B 的朋友，B 是 C 的朋友，那么我们可以认为 A 也是 C 的朋友。所谓的朋友圈，是指所有朋友的集合。
    给定一个 N * N 的矩阵 M，表示班级中学生之间的朋友关系。如果M[i][j] = 1，表示已知第 i 个和 j 个学生互为朋友关系，否则为不知道。你必须输出所有学生中的已知的朋友圈总数。
    示例 1:
        输入:
            [[1,1,0],
            [1,1,0],
            [0,0,1]]
        输出: 2
        说明：已知学生0和学生1互为朋友，他们在一个朋友圈。
        第2个学生自己在一个朋友圈。所以返回2。
    示例 2:
        输入:
            [[1,1,0],
            [1,1,1],
            [0,1,1]]
        输出: 1
        说明：已知学生0和学生1互为朋友，学生1和学生2互为朋友，所以学生0和学生2也是朋友，所以他们三个在一个朋友圈，返回1。
        注意：
        N 在[1,200]的范围内。
    对于所有学生，有M[i][i] = 1。
    如果有M[i][j] = 1，则有M[j][i] = 1。*/
    private int findCircleNum(int[][] M) {
        if (M == null || M.length == 0) {
            return 0;
        }
        int length = M.length;
        boolean[] isCheck = new boolean[length];    // 判断是否已经在别的朋友圈了
        int difNums = 0;    // 不同朋友圈的总数
        for (int i = 0; i < length; i++) {  // 历遍每一个用户
            if (!isCheck[i]) {  // 如果这个用户已经历遍过了，说明已经在别的朋友圈了，就不是新的朋友圈了
                difNums++;
                dfs(i, M, isCheck);
            }
        }
        return difNums;
    }

    private void dfs(int i, int[][] m, boolean[] isCheck) {
        isCheck[i] = true;  // 设置为已经在别的朋友圈状态
        int length = m[i].length;
        for (int j = 0; j < length; j++) {
            if (!isCheck[j] && m[i][j] == 1) {  // 判断是否已经在别的朋友圈，并且还要判断两两之间是不是朋友圈关系
                dfs(j, m, isCheck); // 再接着下钻，深度优先
            }
        }
    }

    public static void main(String[] args) {
        LeetCode_547_035 leetCode_547_035 = new LeetCode_547_035();
        int[][] M = new int[][]{ {1,1,0}, {1,1,0},  {0,0,1} };
        int result = leetCode_547_035.findCircleNum(M);
        System.out.println(result);
    }
}
