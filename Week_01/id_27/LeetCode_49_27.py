class Solution:

    '''
    字母异位词分组，也是通过hashMap将拥有同样字母的设为key，将相同字母的单词放入由数组组成的value中
    最后返回dict.values组成的数组即可
    关键点在于key，这里用了''.join(sorted(st))，就是将单词重新排序后作为一个key
    '''

    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        dict = {}
        for st in strs:
            key = ''.join(sorted(st))
            if key not in dict:
                dict[key] = [st]
            else:
                dict[key] += [st]
        return list(dict.values())