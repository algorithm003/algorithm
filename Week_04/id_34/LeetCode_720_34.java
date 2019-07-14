import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author jinjw
 * @date 2019/7/14
 * @description 给出一个字符串数组words组成的一本英语词典。从中找出最长的一个单词，
 * 该单词是由words词典中其他单词逐步添加一个字母组成。若其中有多个可行的答案，则返回答案中字典序最小的单词。
 * 若无答案，则返回空字符串。
 * 使用排序后,再使用HashSet
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-word-in-dictionary
 */
public class LeetCode_720_34 {
    /**
     * 方法一 Sort+HashSet
     */
    class Solution {
        public String longestWord(String[] words) {
            if (words.length == 0) return "";
            Arrays.sort(words);
            Set<String> validWords = new HashSet<>();
            String ans = "";
            for (String word : words) {
                String prefix = word.substring(0, word.length() - 1);
                if (word.length() == 1 || validWords.contains(prefix)) {
                    validWords.add(word);
                    if (word.length() > ans.length()) ans = word;
                }
            }
            return ans;
        }
    }

    /**
     * 方法二 trie树 +DFS
     */
    class Solution2 {
        private class Trie {
            Trie[] next;
            String word;

            public Trie() {
                next = new Trie[26];
                word = null;
            }
        }

        public void insert(String s, Trie root) {
            for (char c : s.toCharArray()) {
                if (root.next[c - 'a'] == null)
                    root.next[c - 'a'] = new Trie();
                root = root.next[c - 'a'];
            }
            root.word = s;
        }

        String res = "";

        public void dfs(Trie root) {
            if (root == null) {
                return;
            } else if (root.word != null) {
                if (res.length() < root.word.length())
                    res = root.word;
            }
            for (Trie node : root.next) {
                if (node != null && node.word != null)
                    dfs(node);
            }
        }

        public String longestWord(String[] words) {
            Trie root = new Trie();
            for (String s : words)
                insert(s, root);
            dfs(root);
            return res;
        }
    }
}
