import java.util.ArrayList;
import java.util.List;

class MedianFinder {

    /**
     * initialize your data structure here.
     */
    List<Integer> list;

    /**
     * initialize your data structure here.
     */
    public MedianFinder() {
        list = new ArrayList();
    }

    public void addNum(int num) {
        int left = 0, right = list.size() - 1;
        while (left < right) {
            int mid = left + (right - left) / 2, val = list.get(mid);
            if (val < num) left = mid + 1;
            else right = mid;
        }
        if (list.size() > 0 && num > list.get(list.size() - 1)) list.add(num);
        else list.add(left, num);
    }

    public double findMedian() {
        int len = list.size();
        if (len % 2 == 1) return (double) list.get(len / 2);
        else return list.get(len / 2) / 2.0 + list.get(len / 2 - 1) / 2.0;
    }

    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        medianFinder.addNum(3);
        medianFinder.addNum(6);
        double result = medianFinder.findMedian();
        System.out.println(result);
    }
}