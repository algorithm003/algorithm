class Solution:

    '''
    使用current作为height数组下标，用来当作右墙壁边界
    statck将数据一个个推入，当发现当前高度比栈顶高度高，即产生高度差，就可以产生积水（左边有边界的情况下）
    两个墙壁取较小值，再计算左右边界之间的距离，即可算出该范围内的积水，再用sum叠加积水数据
    需注意minH，高低两个柱体也可以装水，不一定是从0开始。所以需要minH-h，算出高度差。
    '''


    def trap(self, height: List[int]) -> int:
        current, sum = 0, 0
        statck = []
        while current < len(height):
            while statck and height[current] > height[statck[-1]]:
                h = height[statck.pop()]
                distance = current - statck[-1] - 1
                minH = min(height[current], height[statck[-1]])
                sum = sum + distance * (minH - h)
            statck.append(current)
            current += 1
        return sum