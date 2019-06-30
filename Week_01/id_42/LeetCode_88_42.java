//给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。 
//
// 说明: 
//
// 
// 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。 
// 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。 
// 
//
// 示例: 
//
// 输入:
//nums1 = [1,2,3,0,0,0], m = 3
//nums2 = [2,5,6],       n = 3
//
//输出: [1,2,2,3,5,6] 
//

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0;
        int j = 0;
        int k = 0;
        int[] nums11 = nums1.clone();
        while (i < m && j < n) {
            if (nums2[j] < nums11[i]) {
                nums1[k++] = nums2[j++];
                continue;
            }
            nums1[k++] = nums11[i++];
        }
        if (i == m) {
            while (j < n) nums1[k++] = nums2[j++];
        } else {
            while (i < m) nums1[k++] = nums11[i++];
        }
        System.out.println(nums1.toString());
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 5, 6};
        int n = 3;
        Solution solution = new Solution();

        solution.merge(nums1, m, nums2, n);
    }
}