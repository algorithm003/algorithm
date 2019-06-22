/**
 * @param {number[]} nums1
 * @param {number} m
 * @param {number[]} nums2
 * @param {number} n
 * @return {void} Do not return anything, modify nums1 in-place instead.
 */
var merge = function(nums1, m, nums2, n) {
  let current = nums1.length - 1
  while (current >= 0) {
    if (!n) return
    if (m < 0) {
      nums1[current--] = nums2[--n]
    }
    if (n < 0) {
      nums1[current--] = nums1[--m]
    }
    if (nums1[m - 1] > nums2[n - 1]) {
      nums1[current--] = nums1[--m]
    } else {
      nums1[current--] = nums2[--n]
    }
  }
}
