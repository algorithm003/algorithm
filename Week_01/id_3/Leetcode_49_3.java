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

    public static void main(String[] args) {
        String[] str = {"eat", "tea", "tan", "ate", "nat", "bat"};
         groupAnagrams(str).forEach((k,v)->{
             for (String s :
                     v) {
                 System.out.println(s);

             }
         });

    }

    public static Map<String ,List<String>> groupAnagrams(String[] strs){
        Map<String,List<String>> hashMap = new HashMap<>();
        for (String s : strs ) {

            char[] chars = s.toCharArray();
            Arrays.sort(chars);

            hashMap.putIfAbsent(String.valueOf(chars),new ArrayList<>());
            hashMap.get(String.valueOf(chars)).add(s);

        }

        return hashMap;

    }
}
