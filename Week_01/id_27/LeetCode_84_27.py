class Solution:

    '''
    计算最大矩阵面积
    在statck初始化为[-1]，还有heights append 了0，是为了方便第一个柱形的计算。否则w宽度就为0了，还有就是方便最小的那个柱体的计算。
    重点在于判断heights[i] < heights[statck[-1]]
    代码里可以发现，当前柱体大于栈顶元素时，就继续push到栈中。当小于栈顶元素时，则进行面积计算。
    此时的heights[i]相当于一个右边界，计算左边所有存在于栈中柱体的面积情况，
    heights[statck[-1]] < heights[i]的那个栈元素相当于左边界
    计算左右两个边界的所有可能的面积值，并且取最大值。因为这之间的柱体是以此增大的（因为heights[i] > heights[statck[-1]]时直接进栈了）
    所以计算的时候从最高的柱体开始计算，此时第一个柱体的时候宽度为1，依次计算，取当前柱体的高度和计算后的宽度，
    越往左的柱体宽度越宽，因为在边界之间的范围中，右边的柱体均比当前柱体高，所以左边的柱体计算宽度时可以取到右边界（不包括右边界本身，所以-1）
    最后栈中剩下最小的那个元素，和-1，通过最初heights.append了0，这个0作为了右边界，计算全局宽度面积，所以是i - (-1) -1，因为只有一个边界
    '''

    def largestRectangleArea(self, heights: List[int]) -> int:
        statck = [-1]
        area = 0
        heights.append(0)
        for i in range(len(heights)):
            while statck and heights[i] < heights[statck[-1]]:
                h = heights[statck.pop()]
                w = i - statck[-1] - 1
                area = max(area, h * w)
            statck.append(i)
        heights.pop()
        return area