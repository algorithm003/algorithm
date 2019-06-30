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
 * 删除最外层的括号
 */
public class LeetCode_1021_050 {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LeetCode_1021_050 solution = new LeetCode_1021_050();
		System.out.println(solution.removeOuterParentheses("(())(()(()))"));
	}

	public String removeOuterParentheses(String S) {
	       if(S == null){
				return null;
			}
			if(S.length() == 0){
				return "";
			}
			char[] charArr = S.toCharArray();
			Stack<Character> stack = new Stack<>();
			StringBuilder strBuild = new StringBuilder();
			int n = 0;
			Set<Integer> setval = new HashSet<>();
			for(int i=0; i<charArr.length; i++){
				if(stack.size()==0){
					stack.add(charArr[i]);
					setval.add(i);
					n++;
					continue;
				}
				StringBuilder strtmp = new StringBuilder();
				if(strtmp.append(stack.get(stack.size()-1)).append(charArr[i]).toString().equals("()")){
					if(stack.size()==1 && n==1){
						setval.add(i);
						n=0;
					}
					stack.pop();
				}else{
					stack.add(charArr[i]);					
				}
			}
			for(int i=0; i<charArr.length; i++){
				if(!setval.contains(i)){
					strBuild.append(charArr[i]);
				}
			}
			return strBuild.toString();
	    }
}