// 注意格式

/**
 * 链接： https://leetcode-cn.com/problems/merge-sorted-array/
 */
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i=n+m-1;
        while(m!=0&&n!=0){
        if(nums1[m-1]>nums2[n-1]){
            nums1[i--]=nums1[m---1];
        }else{
            nums1[i--]=nums2[n---1];
        }
    }
        System.arraycopy(nums2, 0, nums1, 0, n);

    }
}
/**
 * 思考：
 * 1.一般而言，对于有序数组可以通过 双指针法 达到O(n + m)的时间复杂度。
 * 2.为什么最后只从2数组赋值到1数组？因为当n=0时不复制，1数组剩下的已经排好序。n>0
 * 时会将最小的元素复制进1数组前n位。
 */