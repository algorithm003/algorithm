class Solution {
    public String removeDuplicates(String S) {

        /**
         * 去重可利用栈来解
         * 与栈顶对比，重复移除，否则入栈
         */
        // 将字符串转成字符
        char[] chars = S.toCharArray();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i<chars.length; i++) {
            if (stack.isEmpty() || stack.peek() != chars[i]) {
                stack.push(chars[i]);
            }else {
                stack.pop();
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char c: stack) {
            sb.append(c);
        }
        
        return sb.toString();
    }
}
