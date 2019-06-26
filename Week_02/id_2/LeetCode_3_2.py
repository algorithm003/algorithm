"""
    @author: Merlin 2019.06.27
    3.Longest Substring Without Repeating Characters
    思路: 用一个临时数组temp存储最长子串的每个元素，方法2是用哈希表来存储，有所区别
    问题: Python中用in来查找item是否存在于temp中，这里的时间复杂度应该是O(len(temp))，所以算法的总时间复杂度应该是O(n * len(temp))对吗：  对的！
    注: 如果超哥检查作业看到了，能否解答一下这个问题和Solution_2的问题
    time: O(n * len(temp)) space: O(len(temp)) 注: time和space未下定论
    资料reference: https://www.cnblogs.com/work115/archive/2016/06/23/5610680.html
"""
class Solution_1:
    def lengthOfLongestSubstring(self, s: str) -> int:
        res, temp = 0, []
        for item in s:
            if item in temp:
                if res < len(temp):
                    res = len(temp)
                temp = temp[temp.index(item) + 1:]
            temp.append(item)

        return max(res, len(temp))


"""
    @author: Merlin 2019.06.27
    3.Longest Substring Without Repeating Characters
    思路: 用一个哈希表和一个指针start，start指向当前重复字符的下一个字符，表示从start指向的字符作为最长子串的起点
    问题: 用in去查找c是否存在于哈希表中，时间复杂度是O(1),所以算法的总时间复杂度是O(n)对吗
    time: O(n) space: O(n) 注: space在最坏情况下是O(n)，最好是O(k)，k为字符串内字母的种类数
"""
class Solution_2:
    def lengthOfLongestSubstring(self, s: str) -> int:
        used = {}
        max_length = start = 0
        for i, c in enumerate(s):
            if c in used and start <= used[c]:
                start = used[c] + 1
            else:
                max_length = max(max_length, i - start + 1)
            used[c] = i

        return max_length


if __name__ == "__main__":
    """别人的解法看不懂可以试试debug，查看每个变量的值"""
    s = "abcabcbb"
    # test = Solution_1()
    test = Solution_2()
    test.lengthOfLongestSubstring(s)