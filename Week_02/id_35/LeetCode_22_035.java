package week2;

import java.util.ArrayList;
import java.util.List;

/**
 * @ author: Suhb
 * @ date: 2019/6/25 17:58
 * @ description: 递归： 22. 括号生成
 */
public class LeetCode_22_035 {
    /*给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
    例如，给出 n = 3，生成结果为：
            [
            "((()))",
            "(()())",
            "(())()",
            "()(())",
            "()()()"
            ]*/
    private List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<String>();
        if (n < 1) {
            return list;
        }
        getTotals(n, "", 0, 0,  list);
        return list;
    }

    private void getTotals(int n, String s, int left, int right, List<String> list) {
        if ((left + right) == n*2) {    // 左括号 + 右括号 == 总数 即已经完成
            list.add(s);
            return;
        }
        if (left < n)   // 左括号必须 < n， 下钻
            getTotals(n , s + "(", left + 1, right, list);
        if (right < left)   // 右括号必须 < 左括号，下钻
            getTotals(n, s + ")", left, right + 1, list);
    }

    public static void main(String[] args) {
        LeetCode_22_035 leetCode_22_035 = new LeetCode_22_035();
        System.out.println(leetCode_22_035.generateParenthesis(3));
    }
}
