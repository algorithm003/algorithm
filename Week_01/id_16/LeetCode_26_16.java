public class LeetCode026 {

    public int removeDuplicates(int[] nums) {
        //checking
        if (nums == null || nums.length ==0) {
            return 0;
        }

        if (nums.length == 1) {
            return 1;
        }

        int next = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i-1]) {
                nums[next] = nums[i];
                next ++;
            }
        }

        return next;
    }
}
