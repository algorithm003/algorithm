import java.util.PriorityQueue;

class KthLargest {
    final PriorityQueue<Integer> minheap;
    final int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        minheap = new PriorityQueue<>(k);

        for (int i : nums) {
            add(i);
        }
    }

    public int add(int val) {
        if (minheap.size() < k) {
            minheap.offer(val);
        } else if (minheap.peek() < val) {
            minheap.poll();
            minheap.offer(val);
        }
        return minheap.peek();
    }
}
