/*
*
*   242. 有效的字母异位词
*   给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
*
*   学号：020
*
* */


class Solution {


    //方法一：创建两个26长度的数组，分别遍历两个字符串中每个字母出现的个数，最后判断每个字母的个数是否相等
    public boolean isAnagram1(String s, String t) {

        if (s.length() != t.length()){
            return false;
        }

        int[] sCounts = new int[26];
        int[] tCounts = new int[26];

        for (char ch : s.toCharArray()){
            //利用了减 'a' 的 ASCII 码就是从 a 开始的索引。
            sCounts[ch - 'a']++;
        }

        for (char ch : t.toCharArray()) {
            tCounts[ch - 'a']++;
        }

        for (int i = 0; i < sCounts.length ; i++){
            if (sCounts[i] != tCounts[i]){
                return false;
            }
        }
        return true;
    }


    //方法二：只利用新建一个初始值为0的26个元素的数组，字符串 s 中出现字母就在对应位置计数 +1 ，字符串 t 中出现字母就在对应位置计数 -1 ，最后判断数组是否有计数不是0的情况。
    public boolean isAnagram2(String s, String t) {

        if (s.length() != t.length()){
            return false;
        }

        int[] sCounts = new int[26];
        for (char ch : s.toCharArray()){
            sCounts[ch - 'a']++;
        }
        for (char ch : t.toCharArray()) {
            sCounts[ch - 'a']--;
        }
        for (int i = 0; i < sCounts.length ; i++){
            if (sCounts[i] != 0){
                return false;
            }
        }
        return true;
    }


    //方法3：原理同方法2，但通过共用一个遍历索引 idx 记录字母出现的计数操作，节省了一个循环。
    public boolean isAnagram3(String s, String t) {

        if (s.length() != t.length()){
            return false;
        }

        int[] sCounts = new int[26];
        int idx = 0;
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();
        while (idx < sArray.length){
            char sch = sArray[idx];
            sCounts[sch - 'a']++;
            char tch = tArray[idx];
            sCounts[tch - 'a']--;
            idx++;
        }
        for (int i = 0; i < sCounts.length ; i++){
            if (sCounts[i] != 0){
                return false;
            }
        }
        return true;
    }


    //方法4：通过 Java 的工具类，排序两个字符串的字母，然后逐一判断对应位置的字母是否相等。
    public boolean isAnagram4(String s, String t) {

        if (s.length() != t.length()){
            return false;
        }

        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        Arrays.sort(sChars);
        Arrays.sort(tChars);
        return String.valueOf(sChars).equals(String.valueOf(tChars));
    }


    //方法5：利用 hashMap 操作，字母作为Key，计数作为值。 遍历两个字符串，字符串 s 中有的字母，则在 map 设置对应计数；字符串 t 中有的字母，则在 map 中减除。最后判断 map 是否空。
    public boolean isAnagram5(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()){
            ((HashMap) map).put(ch, map.getOrDefault(ch, 0 ) + 1);
        }
        for (char ch : t.toCharArray()){
            Integer count = map.get(ch);
            if (count == null){
                return false;
            } else if (count > 1){
                map.put(ch, count-1);
            }else {
                map.remove(ch);
            }
        }
        return map.isEmpty();
    }


}

// 很厉害！！！