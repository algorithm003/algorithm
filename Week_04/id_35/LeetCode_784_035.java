package week4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ author: Suhb
 * @ date: 2019/7/11 15:36
 * @ description: 784. 字母大小写全排列
 */
public class LeetCode_784_035 {
    /*给定一个字符串S，通过将字符串S中的每个字母转变大小写，我们可以获得一个新的字符串。返回所有可能得到的字符串集合。
    示例:
    输入: S = "a1b2"
    输出: ["a1b2", "a1B2", "A1b2", "A1B2"]

    输入: S = "3z4"
    输出: ["3z4", "3Z4"]

    输入: S = "12345"
    输出: ["12345"]

    注意：
    S 的长度不超过12。
    S 仅由数字和字母组成。*/
    private List<String> letterCasePermutation(String S) {
        if (S == null || S.length() == 0) {
            return new ArrayList<>();
        }
        List<String> list = new ArrayList<>();
        int length = S.length();
        char[] s = S.toCharArray();
        getList(s, 0, list);
        return list;
    }

    private void getList(char[] s, int i, List<String> list) {
        if (i == s.length) {
            list.add(String.valueOf(s));
            return;
        }
        getList(s, i + 1, list);
        if (s[i] < '0' || s[i] > '9') {
            s[i] ^= (1 << 5);
            getList(s, i + 1, list);
        }
    }

    public static void main(String[] args) {
        LeetCode_784_035 leetCode_784_035 = new LeetCode_784_035();
        String s = "a1b2";
        List<String> list = leetCode_784_035.letterCasePermutation(s);
        System.out.println(Arrays.toString(list.toArray()));
    }
}
