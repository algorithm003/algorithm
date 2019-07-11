package Week_04.id_37;

import java.util.Arrays;

/**
 * 类描述：
 * 创建人： Sun YongMeng
 * 创建时间：2019/7/11 10:43
 * 修改人：  Sun YongMeng
 * 修改时间：2019/7/11 10:43
 * 修改备注：
 */
public class LeetCode_455_037 {
    /**
     * 分发饼干
     * 假设你是一位很棒的家长，想要给你的孩子们一些小饼干。
     * 但是，每个孩子最多只能给一块饼干。
     * 对每个孩子 i ，都有一个胃口值 gi ，这是能让孩子们满足胃口的饼干的最小尺寸；
     * 并且每块饼干 j ，都有一个尺寸 sj 。
     * 如果 sj >= gi ，我们可以将这个饼干 j 分配给孩子 i ，这个孩子会得到满足。
     * 你的目标是尽可能满足越多数量的孩子，并输出这个最大数值。
     * @param g
     * @param s
     * @return
     */
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0,j = 0,k = g.length,l = s.length;
        while(i < k && j < l){
            if (g[i] <= s[j]){ i++;}
            j++;
        }
        return i;
    }
}
