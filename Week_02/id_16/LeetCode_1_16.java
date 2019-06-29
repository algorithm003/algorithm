import java.util.HashMap;

public class LeetCode_1_16 {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i ++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i ++) {
            int second = target - nums[i];
            if (map.containsKey(second) && map.get(second) != i) {
                return new int[]{i, map.get(second)};
            }
        }

        return new int[0];
    }
}
