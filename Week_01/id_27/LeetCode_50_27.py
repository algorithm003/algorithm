class Solution:

    '''
    求x^n的结果，可以用二分法来解决该问题，如2的10次方可以转换为4的5次方来计算，从而达到减少时间复杂度的目的
    即myPow(x*x, n/2)
    主要该题还需要注意其他的n的情况，需要分别考虑
    '''
    
    def myPow(self, x: float, n: int) -> float:
        if n == 0:
            return 1
        elif n < 0:
            return 1 / self.myPow(x, -n)
        elif n % 2:
            return x * self.myPow(x, n - 1)
        else:
            return self.myPow(x*x, n / 2)