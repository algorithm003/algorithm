
public class LeetCode_189_13 {

    public void rotate(int[] nums, int k) {
        int n = nums.length;
        for (int i = 0; i < k; i++) {
            // 保存当前数组最后一位，原数组后移一位后，将数组最后一位数值放到第一位
            int temp = nums[n - 1];
            // 数组所有值后移一位
            for (int j = n - 1; j > 0; j--) {
                nums[j] = nums[j - 1];
            }
            nums[0] = temp;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        LeetCode_189_13 test = new LeetCode_189_13();
        int[] nums = new int[]{1,3,4,67,2};
        test.rotate(nums,2);
        for(int i=0;i<nums.length;i++){
            System.out.print(" "+nums[i]);
        }

    }
}
