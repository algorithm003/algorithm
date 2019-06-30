package algorithm.Week_02.id_50;

import java.util.*;

/**
 * Created by yu on 2019/6/29.
 * 前K个高频单词
 */
public class LeetCode_692_050 {
    public List<String> topKFrequent(String[] words, int k) {
        List<String> list = new ArrayList<>();
        Map<String, Integer> map = new HashMap<String, Integer>();

        for (int i = 0; i < words.length; i++) {
            map.put(words[i], map.getOrDefault(words[i], 0) + 1);
        }
        PriorityQueue<String> queue = new PriorityQueue<>(k, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (map.get(o1).equals(map.get(o2))) {
                    return o2.compareTo(o1);
                } else {
                    return map.get(o1).compareTo(map.get(o2));
                }
            }
        });
        for (String key : map.keySet()) {
            if (queue.size() < k) {
                queue.add(key);
            } else if (queue.comparator().compare(key, queue.peek()) > 0) {
                queue.poll();
                queue.add(key);
            }
        }
        String[] strArray = new String[k];
        for (int i = k - 1; i >= 0; i--) {
            strArray[i] = queue.poll();
        }
        return Arrays.asList(strArray);
    }
}
