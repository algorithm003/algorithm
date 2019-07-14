package week4;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @ author: Suhb
 * @ date: 2019/7/10 15:05
 * @ description: 720. 词典中最长的单词
 */
public class LeetCode_720_035 {
    /*给出一个字符串数组words组成的一本英语词典。从中找出最长的一个单词，该单词是由words词典中其他单词逐步添加一个字母组成。若其中有多个可行的答案，则返回答案中字典序最小的单词。
    若无答案，则返回空字符串。
    示例 1:
        输入:
        words = ["w","wo","wor","worl", "world"]
        输出: "world"
        解释:
        单词"world"可由"w", "wo", "wor", 和 "worl"添加一个字母组成。
    示例 2:
        输入:
        words = ["a", "banana", "app", "appl", "ap", "apply", "apple"]
        输出: "apple"
        解释:
        "apply"和"apple"都能由词典中的单词组成。但是"apple"得字典序小于"apply"。
    注意:
        所有输入的字符串都只包含小写字母。
        words数组长度范围为[1,1000]。
        words[i]的长度范围为[1,30]。*/

    /**
     * 没看明白为什么错了。
     * 执行结果：
     解答错误
     显示详情
     输入:
     ["ogz","eyj","e","ey","hmn","v","hm","ogznkb","ogzn","hmnm","eyjuo","vuq","ogznk","og","eyjuoi","d"]
     输出
     "ogznkb"
     预期结果
     "eyj"
     * @param words
     * @return
     */
    private String longestWord(String[] words) {
        if (words == null || words.length == 0) {
            return null;
        }
        Map<String, Integer> wordsMap = new HashMap();
        for (String word : words) {
            wordsMap.put(word, 0);
        }
        Arrays.sort(words);
        int length = words.length;
        int maxValue = 0;
        String maxValueWord = null;
        for (int i = length - 1; i >= 0; i--) {
            int nums = 0;
            String key = words[i].substring(0, words[i].length() - 1);
            while (wordsMap.containsKey(key)) {
                nums++;
                key = key.substring(0, key.length() - 1);
                wordsMap.put(words[i], nums);
            }
            if (nums >= maxValue) {
                maxValue = nums;
                maxValueWord = words[i];
            }
        }
        return maxValueWord;
    }

    public static void main(String[] args) {
        LeetCode_720_035 leetCode_720_035 = new LeetCode_720_035();
        String[] words = new String[]{"ogz","eyj","e","ey","hmn","v","hm","ogznkb","ogzn","hmnm","eyjuo","vuq","ogznk","og","eyjuoi","d"};
        String result = leetCode_720_035.longestWord(words);
        System.out.println(result);
    }
}
