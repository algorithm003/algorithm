package Week_03.id_37;

import java.util.List;
import java.util.PriorityQueue;

/**
 * 类描述：数据流中的第K大元素
 * 创建人： Sun YongMeng
 * 创建时间：2019/7/4 9:15
 * 修改人：  Sun YongMeng
 * 修改时间：2019/7/4 9:15
 * 修改备注：
 */
public class LeetCode_703_37 {
    PriorityQueue<Integer> pq;
    int k;
    public LeetCode_703_37(int k, int[] nums) {
        this.k = k;
        pq = new PriorityQueue<>(k);
        for (int n: nums){
            this.add(n);
        }
    }

    public int add(int val) {
        if(pq.size() < k){pq.offer(val);}
        else if(pq.peek() < val){
            pq.poll();
            pq.offer(val);
        }
        return pq.peek();
    }

    public static void main(String[] args) {
        int[] nums = {1,6,5,8,9,7};
        LeetCode_703_37 obj = new LeetCode_703_37(5, nums);
        int param_1 = obj.add(10);
        System.out.println(param_1);
    }
}
