using System;

public class LeedCode_3_59
{
    /// <summary>
    /// 哈希表
    /// 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
    /// 示例 1:
    /// 输入: "abcabcbb"
    /// 输出: 3
    /// 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
    /// 来源：力扣（LeetCode）
    /// 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
    /// 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    /// </summary>
    /// <param name="s"></param>
    /// <returns></returns>
    public int LengthOfLongestSubstring(string s)
    {
        Stack<string> tempStrCollect = new Stack<string>();
        tempStrCollect.Push("");
        //Stack<string> strCollect = new Stack<string>();
        StringBuilder tempStr = new StringBuilder();
        for (int j = 0; j < s.Length; j++)
        {
            for (int i = j; i < s.Length; i++)
            {
                if (tempStr.ToString().IndexOf(s[i]) == -1)
                {
                    tempStr.Append(s[i]);
                }
                else
                {
                    //如何利用栈弹出与比较数值大小
                    var tempStrCurrent = tempStr.ToString();
                    //strCollect.Push(tempStrCurrent);
                    var tempStrBefore = tempStrCollect.Pop();
                    if (tempStrBefore.Length < tempStrCurrent.Length)
                    {
                        tempStrCollect.Push(tempStrCurrent);
                    }
                    else
                    {
                        tempStrCollect.Push(tempStrBefore);
                    }
                    tempStr.Clear();
                    break;
                }
            }
        }
        var maxStr = tempStrCollect.Pop().Length;
        if (0 == maxStr)
        {
            maxStr = tempStr.Length;
        }

        return maxStr;
    }
}
