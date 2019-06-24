import java.util.Stack;

public class LeetCode1021 {
    public String removeOuterParentheses(String S) {
        if (S == null || S.length() <= 1) {
            return S;
        }

        Stack<Character> stack = new Stack<Character>();
        char[] strArray = S.toCharArray();
        int startIndex = 0;
        int endIndex = 0;
        StringBuilder res = new StringBuilder("");

        for (int i = 0; i < strArray.length; i ++) {
            if (stack.empty()) {
                stack.push(strArray[i]);
                //记录原语开始的位置
                startIndex = i + 1;
            }
            else {
                if (strArray[i] != stack.peek()) {
                    stack.pop();
                    if (stack.empty()) {
                        endIndex = i;
                        res.append(S.substring(startIndex, endIndex));
                    }
                }
                else {
                    stack.push(strArray[i]);
                }
            }
        }

        return res.toString();
    }
}
