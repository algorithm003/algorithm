from typing import List


"""
    @author: Merlin 2019.07.14
    240.Search a 2D Matrix II
    思路: 由于给定矩阵从左到右升序，从上到下升序，可以通过从右上角遍历到左下角来找到target
    time: O(m + n) 最多遍历m + n - 1个元素
    space: O(1) 借助指针j作为数组下标来访问
"""
class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        j = -1
        for row in matrix:
            while j + len(row) >= 0 and row[j] > target:
                j -= 1
            if j + len(row) >= 0 and row[j] == target:
                return True
        return False