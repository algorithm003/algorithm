/**
 * 给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们
 * 链接：https://leetcode-cn.com/problems/remove-all-adjacent-duplicates-in-string/
 */

class Solution {
    public String removeDuplicates(String S) {
        Stack<Character> stack = new Stack<>();
        char[] charArray=S.toCharArray();
        for (int i = 0; i < S.length(); i++) {
            if (stack.isEmpty()||stack.peek() != charArray[i]) {
                stack.push(charArray[i]);
            }else{
                stack.pop();
            }
        }
        StringBuffer s=new StringBuffer();
        // 从栈底元素开始遍历
      for (Character   c : stack) {
          s.append(c);
      }       
            return s.toString();
    }
}
/**
* 思路：通过一个栈来判断当前字符和栈顶元素是否相同。
*/