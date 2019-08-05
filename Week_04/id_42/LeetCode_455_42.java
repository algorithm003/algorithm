public class LeetCode_455_42 {
    /**
     * 贪心算法
     * 排好序，双指针，满足胃口，饼干和胃口都往前走一步，否则饼干后退一步
     * @param g
     * @param s
     * @return
     */
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g); // 孩子
        Arrays.sort(s); // 饼干
        int i = 0;
        int j = 0;
        int count = 0;
        while (i < g.length && j < s.length) {
            if (g[i] <= s[j]) {
                count++;
                i++;
            }
            j++;
        }
        return count;
    }

    @Test
    public void test() {
        int[] g = {1, 2};
        int[] s = {1, 2, 3};
        System.out.println(findContentChildren(g, s));
    }
}
