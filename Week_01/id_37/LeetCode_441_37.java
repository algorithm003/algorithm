package Week_01.id_37;

/**
 * 类描述：
 * 创建人： Sun YongMeng
 * 创建时间：2019/6/17 15:45
 * 修改人：  Sun YongMeng
 * 修改时间：2019/6/17 15:45
 * 修改备注：
 * @author Symer
 */
public class LeetCode_441_37 {
    /**
     * 毎摆放一次硬币,改变剩余数,直到为负数
     * @param n
     * @return
     */
    public int arrangeCoins(int n) {
        int num = 0;
        for (int j = 1; j <= n; j++) {
            n -= j;
            num++;
        }
        return num ;
    }
}
