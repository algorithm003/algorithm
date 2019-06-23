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
 * 有效的字母异位词
 */
public class LeetCode_242_050 {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LeetCode_242_050 solution = new LeetCode_242_050();
		int[] nums = {1,2};
		String[] strs = {"nozzle","punjabi","waterlogged","imprison","crux","numismatists"};
		System.out.println(solution.isAnagram("dgqztusjuu", "dqugjzutss"));
	}

	public boolean isAnagram(String s, String t) {
        if(s == null || t == null){
			return false;
		}
		if(s.length() != t.length()){
			return false;
		}
		Map<Object, Integer> map1 = new HashMap<>();
		Map<Object, Integer> map2 = new HashMap<>();
		for(int i=0; i<s.length(); i++){
			if(map1.get(s.charAt(i)) != null){
				map1.put(s.charAt(i), map1.get(s.charAt(i))+1);
			}else{
				map1.put(s.charAt(i), 1);				
			}
		}
		for(int i=0; i<t.length(); i++){
			if(map2.get(t.charAt(i)) != null){
				map2.put(t.charAt(i), map2.get(t.charAt(i))+1);
			}else{
				map2.put(t.charAt(i), 1);				
			}
		}
		
		
		return map1.equals(map2);
    }
}