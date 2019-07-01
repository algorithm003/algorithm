//给一非空的单词列表，返回前 k 个出现次数最多的单词。
//
// 返回的答案应该按单词出现频率由高到低排序。如果不同的单词有相同出现频率，按字母顺序排序。
//
// 示例 1：
//
//
//输入: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
//输出: ["i", "love"]
//解析: "i" 和 "love" 为出现次数最多的两个单词，均为2次。
//    注意，按字母顺序 "i" 在 "love" 之前。
//
//
//
//
// 示例 2：
//
//
//输入: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
//输出: ["the", "is", "sunny", "day"]
//解析: "the", "is", "sunny" 和 "day" 是出现次数最多的四个单词，
//    出现次数依次为 4, 3, 2 和 1 次。
//
//
//
//
// 注意：
//
//
// 假定 k 总为有效值， 1 ≤ k ≤ 集合元素数。
// 输入的单词均由小写字母组成。
//
//
//
//
// 扩展练习：
//
//
// 尝试以 O(n log k) 时间复杂度和 O(n) 空间复杂度解决。
//
//

import java.util.*;

class Solution692 {

    public List<String> topKFrequent(String[] words, int k) {
        List<String> ret = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        Queue[] bucket = new Queue[words.length];
        for (String word : map.keySet()) {
            int freq = map.get(word);
            if (bucket[freq] == null) {
                bucket[freq] = new PriorityQueue();
            }
            bucket[freq].offer(word);
        }

        for (int i = bucket.length - 1; i >= 0; i--) {
            if (ret.size() == k) break;
            if (bucket[i] == null) continue;

            Queue<String> q = bucket[i];
            while (!q.isEmpty()) {
                ret.add(q.poll());
                if (ret.size() == k) break;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        String[] words = {"is", "the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
        int k = 4;
        Solution692 solution = new Solution692();
        List<String> ret = solution.topKFrequent(words, k);
        System.out.println(ret);
    }
}