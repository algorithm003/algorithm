class Solution:
    def countSmaller(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        # print(2 & (-2))
        # if not nums:
        #     return []
        # padding = min(nums)
        # if padding <= 0:
        #     nums = [n + 1 - padding for n in nums]
        #     # print(nums)
        # mx = max(nums)
        # T = [0] * (mx + 1)
        # res = []
        #
        # print(nums)
        # def getSum(i):
        #     ans = 0
        #     while i:
        #         ans += T[i]
        #         i = i - i &(-i)
        #     return ans
        #
        # def update(i):
        #     while i < len(T):
        #         T[i] += 1
        #         i = i + i & (-i)
        #
        # for n in nums[::-1]:
        #     res.append(getSum(n-1))
        #     update(n)
        #
        #
        # return res[::-1]

        if not nums:
            return []
        minV = min(nums)
        if minV <= 0:
            nums = [n + 1 - minV for n in nums]

        maxV = max(nums)
        T = [0] * (maxV + 1)


        res = []

        def getSum(i):
            ans = 0
            while i:
                ans += T[i]
                i -= i & (-i)
            return ans

        def update(i):
             while i < len(T):
                 T[i] += 1
                 i += i & (-i)


        for n in nums[::-1]:
            print(n)
            res.append(getSum(n-1))
            update(n)

        return res[::-1]
                





if __name__ == "__main__":
    a = Solution()
    print(a.countSmaller([1,2,4,1]))