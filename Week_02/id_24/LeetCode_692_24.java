package week2.topKFrequentWords;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Given a non-empty list of words, return the k most frequent elements.
 * Your answer should be sorted by frequency from highest to lowest. If two words have the same frequency, then the word with the lower alphabetical order comes first.
 */
public class Solution {
    public List<String> topKFrequent(String[] words, int k) {
		List<String> result = new LinkedList<>();
		Map<String, Integer> map = new HashMap<>();
		
		// Put words in to map, key is the word itself value is the present times of word. 
		for (String word : words) {
			map.put(word, map.getOrDefault(word, 0) + 1);
		}
		
		// Set the rule of priority. 
		// If items sharing the same value, use key(String) alphabetical order
		// If value not same, use the difference to decide priority
		PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(
				(a, b) -> a.getValue() == b.getValue() ? b.getKey().compareTo(a.getKey()) : a.getValue() - b.getValue());

		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			pq.offer(entry);
			if (pq.size() > k) {
				// remove the lower priority items from queue
				// until the queue size is k
				pq.poll();
			}
		}
		
		
		while (!pq.isEmpty()) {
			// add item to the head of the result list
			// that can avoid to use reverse order method
			result.add(0, pq.poll().getKey());
		}

		return result;
    }

	public static void main(String[] args) {
		Solution s = new Solution();

		System.out.println(s.topKFrequent(new String[]{"i", "love", "leetcode", "i", "love", "coding"}, 2));
		System.out.println(s.topKFrequent(new String[] {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"}, 4));
	}

}
