/*
 * @lc app=leetcode.cn id=88 lang=golang
 *
 * [88] 合并两个有序数组
 *
 * https://leetcode-cn.com/problems/merge-sorted-array/description/
 *
 * algorithms
 * Easy (43.64%)
 * Likes:    253
 * Dislikes: 0
 * Total Accepted:    50.1K
 * Total Submissions: 113K
 * Testcase Example:  '[1,2,3,0,0,0]\n3\n[2,5,6]\n3'
 *
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 *
 * 说明:
 *
 *
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 *
 *
 * 示例:
 *
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 *
 * 输出: [1,2,2,3,5,6]
 *
 */

 /*
 1. 不需要copy
 2. 代码简洁和对称性不够
 */

 func merge(nums1 []int, m int, nums2 []int, n int)  {
	nums1Copy := make([]int, m)
	copy(nums1Copy, nums1)

	//初始化 nums1_copy 和 nums2 的下标
	p1,p2 := 0,0

	for i := 0; i < (m + n); i++ {
		//nums1_copy 用完了
		if p1 >= m {
			nums1[i] = nums2[p2]
			p2++
			continue
		}
		//nums2 用完了
		if p2 >= n {
			nums1[i] = nums1Copy[p1]
			p1++
			continue
		}

		if nums1Copy[p1] <= nums2[p2] {
			nums1[i] = nums1Copy[p1]
			p1++
		}else {
			nums1[i] = nums2[p2]
			p2++
		}
	}

	fmt.Println(nums1)
}