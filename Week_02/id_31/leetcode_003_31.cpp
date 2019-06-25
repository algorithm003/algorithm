#include <iostream>
#include <string>
#include <set>
#include <algorithm>

using namespace std;

/*
给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。

示例 1:

输入: "abcabcbb"
输出: 3
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
示例 2:

输入: "bbbbb"
输出: 1
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
示例 3:

输入: "pwwkew"
输出: 3
解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/
namespace version_1
{
    class Solution {
    public:
        int lengthOfLongestSubstring(string s) {
            set<char> record;
            int result = 0;
            for (int end=0,start=0;(end<s.length())&& (start<s.length());)
            {
                if (record.find(s[end])== record.end())
                {
                    record.insert(s[end++]);
                    result = max(result,end-start);
                } else{
                    record.erase(s[start++]);
                }
            }
            return result;
        }
    };
}

namespace version_2
{
    class Solution {
    public:
        int lengthOfLongestSubstring(string s) {
            int count [256] = {0};
            int result = 0;
            for (int end=0,start=0;end<s.length();end++)
            {
                start = max(count[s[end]], start);
                result = max(result, end - start + 1);
                count[s[end]] = end + 1;
            }
            return result;
        }
    };
}

using namespace version_2;

int main() {
    Solution mytest;
    int test1 = mytest.lengthOfLongestSubstring("abcabcbb");
    cout<<test1<<endl;
    int test2 = mytest.lengthOfLongestSubstring("bbbbb");
    cout<<test2<<endl;
    int test3 = mytest.lengthOfLongestSubstring("pwwkew");
    cout<<test3<<endl;
    return 0;
}