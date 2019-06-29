/**
 * 删除最外层的括号
 * 链接：https://leetcode-cn.com/problems/remove-outermost-parentheses/comments/
 */
class Solution {
    public String removeOuterParentheses(String S) {
        StringBuilder sb = new StringBuilder();
        int left = 0, right = 0;
        for (char c : S.toCharArray()) {
            switch (c) {
            case '(':
            // 过滤掉愿语最外层左括号
                if (++left != 1)
                    sb.append(c);
                break;
            case ')':
            // 过滤掉原语最外层右括号
                if (left == ++right) {
                    left = 0;
                    right = 0;
                }else{
                    sb.append(c);
                }
                break;
            }
            
        }
        return sb.toString();
    }
}
/** 
 * 思考： 这道题删除原语外层括号不好想，还有用一个变量来实现的，关于解法还要看看有没有更优雅的实现
 */