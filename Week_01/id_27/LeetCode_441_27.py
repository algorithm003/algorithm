class Solution:
    '''
    硬币排列问题，第n行排n个硬币
    用k=1，n 大于等于0的时候 n -= k， 再k+=1即可计算得出
    这里要注意的是最后结果输出是k - 2
    因为n的循环判断是大于等于0，所以最后一次循环必定不符合规定，为负数。所以要k - 1，加上初始化的时候k = 1
    所以最终结果是k - 2
    '''
    def arrangeCoins(self, n: int) -> int:
        k = 1
        while n >= 0:
            n -= k
            k += 1
        return k - 2