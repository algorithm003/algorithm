public class LeetCode088 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums1 == null && nums2 == null || nums1 != null && nums2 == null
                || n == 0) {
            return;
        }

        if (m == 0) {
            for (int i = 0; i < n; i ++) {
                nums1[i] = nums2[i];
            }
            return;
        }

        int index1 = m - 1;
        int index2 = n - 1;
        int i = m + n - 1;

        // 关于 do-while 的使用 ?..
        do {
            if (index2 < 0 || (index1 >= 0 && nums1[index1] >= nums2[index2])) {
                nums1[i] = nums1[index1];
                index1 --;
            }
            else {
                nums1[i] = nums2[index2];
                index2 --;
            }
            i --;
        } while (index2 >= 0 || index1 >= 0);

        return;
    }
}
