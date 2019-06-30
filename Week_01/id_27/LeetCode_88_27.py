class Solution:
    '''
    利用nums1空间足够，且两个数组都派了序的特性，倒序比对两个数组的各个最大值，更大者放到m+n-1的位置即可
    最后处理nums2数组剩余的元素，将其添加到nums1数组前面
    '''

    def merge(self, nums1: List[int], m: int, nums2: List[int], n: int) -> None:
        while n > 0 and m > 0:
            if nums1[m-1] < nums2[n-1]:
                nums1[m+n-1] = nums2[n-1]
                n -= 1
            else:
                nums1[m+n-1] = nums1[m-1]
                m -= 1

        nums1[:n] = nums2[:n]