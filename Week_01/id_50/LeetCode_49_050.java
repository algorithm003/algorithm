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
 * 字母异位词分组
 */
public class LeetCode_49_050 {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LeetCode_49_050 solution = new LeetCode_49_050();
		String[] strs = {"nozzle","punjabi","waterlogged","imprison","crux","numismatists"};
		solution.groupAnagrams(strs);
	}

	public List<List<String>> groupAnagrams(String[] strs) {
        if( strs.length == 0 ){
			return null;
		}
		Map<String, List> mapList = new HashMap<String, List>();
		for(int i=0; i<strs.length; i++){
			char[] charArr = strs[i].toCharArray();
			Arrays.sort(charArr);
			String sortStr = String.valueOf(charArr);
			if(!mapList.containsKey(sortStr)){
				List<String> listStr = new ArrayList<>();
				listStr.add(strs[i]);
				mapList.put(sortStr, listStr);
			}else{
				List<String> listStr = mapList.get(sortStr);
				listStr.add(strs[i]);
				mapList.put(sortStr, listStr);
			}
		}
		return new ArrayList(mapList.values());
    }
}