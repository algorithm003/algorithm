/**
 * 前K个高频单词
 */

class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0)+1);
        }
        PriorityQueue<String> priorityQueue = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                if (map.get(s1) == map.get(s2)) {
                    return s1.compareTo(s2);
                }
                return map.get(s2) - map.get(s1);
            }
        });
        for (String s : map.keySet()) {
            priorityQueue.add(s);
        }
        ArrayList<String> arrayList = new ArrayList<String>();
        for (int i = 0; i < k; i++) {
            arrayList.add(priorityQueue.poll());
        }
        return arrayList;
    }
}