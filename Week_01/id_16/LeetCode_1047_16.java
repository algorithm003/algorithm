import java.util.Stack;

public class LeetCode1047 {
    public String removeDuplicates(String S) {
        if (S == null || S.length() == 1) {
            return S;
        }

        Stack<Character> stack = new Stack<Character>();
        char[] strArray = S.toCharArray();
        for (int i = 0; i < strArray.length; i ++) {
            if (stack.empty()) {
                stack.push(strArray[i]);
            }
            else {
                if (stack.peek() == strArray[i]) {
                    stack.pop();
                }
                else {
                    stack.push(strArray[i]);
                }
            }
        }

        char[] res = new char[stack.size()];
        for (int j = stack.size() -1; j >= 0; j --) {
            res[j] = stack.pop();
        }

        return String.valueOf(res);
    }
}
