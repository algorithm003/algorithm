# https://leetcode-cn.com/problems/powx-n/submissions/

# 思路 1: 暴力法
# 时间复杂度: O(n)
# 空间复杂度: O(1)

class Solution1:
    def myPow(self, x: float, n: int) -> float:
        s = 1
        m = n if n > 0 else -n
        while m > 0:
            s*=x
            m -= 1
        
        return s if n > 0 else 1 / s
        
# 思路 2: 快速幂(递归法)
# 时间复杂度: O(log(n))
# 空间复杂度: O(log(n))


class Solution:
    def fastPow(self, x: float, m: int) -> float:
        if m == 0:
            return 1
        if m == 1:
            return x

        half = self.fastPow(x, int(m / 2))

        if m & 1 == 0:
            return half * half
        else:
            return half * half * x

    def myPow(self, x: float, n: int) -> float:
        s = self.fastPow(x, n)
        return s if n > 0 else 1 / s