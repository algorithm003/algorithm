package algorithm.Week_04.id_50;

/**
 * Created by yu on 2019/7/14.
 * 求众数
 */
public class LeetCode_169_050 {
    public int majorityElement(int[] nums) {
        int majorityCount = nums.length / 2;
        for (int num : nums) {
            int count = 0;
            for (int elem : nums) {
                if (elem == num) {
                    count += 1;
                }
            }
            if (count > majorityCount) {
                return num;
            }

        }
        return -1;
    }
}
