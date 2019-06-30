import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;



/**
 * @author yu
 * 删除字符串中的所有相邻重复项
 */
public class LeetCode_1047_050 {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LeetCode_1047_050 solution = new LeetCode_1047_050();
		System.out.println(solution.removeDuplicates("abbacaacdad"));
	}

	public String removeDuplicates(String S) {
        if(S == null){
			return null;
		}
		if(S.length() == 0){
			return "";
		}
		char[] charArr = S.toCharArray();
		Stack<Character> stack = new Stack<>();
		for(char c : charArr){
			if(stack.size()==0){
				stack.add(c);			
			}else{
				if(c == stack.get(stack.size()-1)){
					stack.pop();
				}else{
					stack.add(c);
				}
			}
		}
		StringBuilder strBuild = new StringBuilder();
		for(Character c: stack){
			strBuild.append(c);
		}
		return strBuild.toString();
    }
}