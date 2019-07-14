import java.util.Arrays;

public class LeetCode_455_16 {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int gIndex = 0;
        int sIndex = 0;
        int count = 0;

        while (gIndex < g.length && sIndex < s.length) {
            if (g[gIndex] <= s[sIndex]) {
                count ++;
                gIndex ++;
                sIndex ++;
            }
            else {
                sIndex ++;
            }
        }

        return count;
    }
}
