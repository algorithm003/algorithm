package app;

import java.util.*;

/**
 * @author zhongzuoming <zhongzuoming, 1299076979@qq.com>
 * @version v1.0
 * @Description
 * @encoding UTF-8
 * @date 2019/6/22
 * @time 17:29
 * @修改记录 <pre>
 * 版本       修改人         修改时间         修改内容描述
 * --------------------------------------------------
 * <p>
 * --------------------------------------------------
 * </pre>
 */
public class LeetCode49 {

   
    public List<List<String>> groupAnagrams(String[] strs) {
          Map<String,List<String>> hashMap = new HashMap<>();
        for (String s : strs ) {

            char[] chars = s.toCharArray();
            Arrays.sort(chars);

            if(!hashMap.containsKey(String.valueOf(chars))){
                List<String> tempList = new ArrayList<>();
                tempList.add(s);
                hashMap.put(String.valueOf(chars),tempList);
            }else {
                hashMap.get(String.valueOf(chars)).add(s);
            }
        }
        return new ArrayList(hashMap.values());
    }
}
