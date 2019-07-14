import java.util.Arrays;

public class LeetCode_169_16 {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}
