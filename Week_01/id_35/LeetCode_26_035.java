/**
 * @author: Suhb
 * @date: 2019/6/17 17:37
 * @description: 26. 删除排序数组中的重复项
 */
public class LeetCode_26_035 {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0)
            return 0;
        int dif_index = 0;                      // 默认不一样数字的数组指针(慢指针)就是第一个
        int length = nums.length;
        for (int i = 1;i < length; i++) {       // 正常数组指针(快指针)
            if (nums[i] != nums[dif_index]) {   // 快指针与慢指针一样，直接跳过
                dif_index++;
                nums[dif_index] = nums[i];      // 不一样的话,慢指针向前移动一样
            }
        }
        dif_index++;                            // 要加上第一位数
        return dif_index;
    }

    public static void main(String[] args) {
        LeetCode_26_035 leetCode_26_035 = new LeetCode_26_035();
        int nums[] = new int[]{1, 1, 2, 3, 5, 5};
        int dif_nums = leetCode_26_035.removeDuplicates(nums);
        System.out.println("totals: " + dif_nums);
        for (int i = 0; i < dif_nums; i++) {
            System.out.print(" " + nums[i]);
        }
    }
}
