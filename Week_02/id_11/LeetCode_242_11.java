/**
 * 242. 有效的字母异位词
 * https://leetcode-cn.com/problems/valid-anagram/solution/you-xiao-de-zi-mu-yi-wei-ci-by-leetcode/
 */
class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();
        HashMap<Character, Integer> hashMap = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            // 如果没有对应的key，则默认值是0，并且+1
            hashMap.put(sArray[i], hashMap.getOrDefault(sArray[i], 0) + 1);
            hashMap.put(tArray[i], hashMap.getOrDefault(tArray[i], 0) - 1);
        }
        // 利用迭代器遍历
        Iterator<Map.Entry<Character, Integer>> iterator = hashMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Character, Integer> entry = iterator.next();
            if (entry.getValue() != 0)
                return false;
        }

        return true;
    }
}