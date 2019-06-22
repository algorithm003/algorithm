class Solution:
    '''
    删除相邻字母相同的字母，用栈的处理方式较为合适。
    将字母一个一个的推入栈中，如果发现栈顶元素与当前准备推入的元素相同，则直接将栈顶元素弹出
    最后栈中剩余的元素即为答案，将其转换为字符串即可
    '''
    def removeDuplicates(self, S: str) -> str:
        res = []
        for st in S:
            if not st or res[-1] != st:
                res.append(st)
            else:
                res.pop()
        return ''.join(res)