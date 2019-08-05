import java.lang.annotation.Retention;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=720 lang=java
 *
 * [720] 词典中最长的单词
 */
class Solution {
    public String longestWord(String[] words) {
        // 用来快速查找
        HashSet<String> dict = new HashSet<String>();
        for (String s : words) {
            dict.add(s);
        }
        // 根据题意中的排序规则自定义排序
        Arrays.sort(words, (a, b) -> {
            if (a.length() != b.length()) {
                return (a.length() - b.length());
            } else {
                return b.compareTo(a);
            }
        });
        // 最长的单词一定在后面
        for (int i = words.length - 1; i >= 0; i--) {
            if (helper(dict, words[i]))
                return words[i];
        }
        return "";
    }

    public Boolean helper(Set<String> dict,String word){
        for (int i = 1; i <word.length(); i++) {
            // 通过substring分别匹配每一个元素
            if(!dict.contains( word.substring(0,i))){
                return false;
            }
        }
         return true;
    }
}
