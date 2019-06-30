//给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。 
//
// 示例: 
//
// 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
//输出:
//[
//  ["ate","eat","tea"],
//  ["nat","tan"],
//  ["bat"]
//] 
//
// 说明： 
//
// 
// 所有输入均为小写字母。 
// 不考虑答案输出的顺序。 
// 
//

import java.util.*;

class Solution49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        List<List<String>> lists = new ArrayList<>();
        for (int i = 0; i < strs.length; i++) {
            char ch[] = strs[i].toCharArray();
            Arrays.sort(ch);
            String s = String.valueOf(ch);
            if (!map.containsKey(s)) {
                map.put(s, new ArrayList());
            }
            map.get(s).add(strs[i]);
        }
        for (List list : map.values()) {
            lists.add(list);
        }
        System.out.println(lists);
        return lists;
    }

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        Solution49 solution49 = new Solution49();
        solution49.groupAnagrams(strs);
    }
}