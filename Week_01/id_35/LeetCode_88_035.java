import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author: Suhb
 * @date: 2019/6/19 21:19
 * @description: 88. 合并两个有序数组
 */
public class LeetCode_88_035 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
    }

    public static void main(String[] args) {
        int m = 3;
        int nums1[] = new int[]{1,2,3,0,0,0};
        int n = 3;
        int nums2[] = new int[]{2,5,6};
        LeetCode_88_035 leetCode_88_035 = new LeetCode_88_035();
        leetCode_88_035.merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }
}
