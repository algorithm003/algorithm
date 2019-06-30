/*
*
*   88. 合并两个有序数组
*   给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
*   说明:
*   初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
*   你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
*
*   学号：020
*
* */


class Solution {

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int idx1 = m-1;     //数组 nums1 的最后索引值
        int idx2 = n-1;     //数组 nums2 的最后索引值
        int idxNew = m + n - 1;   //数组 nums1 新的最后元素索引

        //从新数组索引最尾开始遍历，将数组 nums1、nums2 两个数组中比较最大的元素，从最后逐步有序填在新数组中。
        while (idx1 >=0 && idx2>=0){
            if (nums1[idx1] > nums2[idx2]){
                nums1[idxNew--] = nums1[idx1--];
            }else{
                nums1[idxNew--] = nums2[idx2--];
            }
        }

        //*将 nums2 数组中有可能剩下未遍历的元素(比 nums1 数组的元素都小的值)填充到新数组 nums1 中。
        while (idx2 >= 0){
            nums1[idxNew--] = nums2[idx2--];
        }

    }
}