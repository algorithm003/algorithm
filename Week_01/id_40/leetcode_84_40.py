# https://leetcode-cn.com/problems/largest-rectangle-in-histogram/submissions/

# 思路 1: 暴力法
# 对于每个索引,都尝试向左,向右延伸,计算出所有可能的值,再找出最大值
# 时间复杂度: O(n^2)
# 空间复杂度: O(n)


class Solution1:
    def largestRectangleArea(self, heights: List[int]) -> int:

        if not heights:
            return 0

        values = [0] * len(heights)

        m = heights[0]

        for i, v in enumerate(heights):
            values[i] = v
            if v > m:
                m = v

            if i > 0:
                for l, v1 in enumerate(heights[i - 1::-1]):  # 向左延伸
                    if v1 >= v:
                        values[i] += v
                        if values[i] > m:
                            m = values[i]
                    else:
                        break
            for r, v2 in enumerate(heights[i + 1:]):  # 向右延伸
                if v2 >= v:
                    values[i] += v
                    if values[i] > m:
                        m = values[i]
                else:
                    break

        return m



# 思路 2: 待总结...