/**
 * @author: Suhb
 * @date: 2019/6/18 10:59
 * @description: 27. 移除元素
 */
public class LeetCode_27_035 {
    public int removeElement(int[] nums, int val) {
        int length = nums.length;
        if (length == 0) {
            return length;
        }
        int dif_index = 0;                      // 默认不一样数字的数组指针(慢指针)就是第一个
        for (int i = 0; i < length; i++) {      //因为是给定的值，所以要从第1个开始移动
            if (nums[i] != val) {               //如果值一样，慢指针停留，快指针移动
                nums[dif_index] = nums[i];      //当前快指针的值与目标值不一样，则慢指针的值就是当前值
                dif_index++;                    //慢指针移动
            }
        }
        return dif_index;
    }

    public static void main(String[] args) {
        LeetCode_27_035 leetCode_27_035 = new LeetCode_27_035();
        int nums[] = new int[]{1, 2, 2, 3, 3, 4, 5};
        int dif_nums =  leetCode_27_035.removeElement(nums, 2);
        System.out.println("totals: " + dif_nums);
        for (int i = 0; i < dif_nums; i++) {
            System.out.print(" " + nums[i]);
        }
    }
}
