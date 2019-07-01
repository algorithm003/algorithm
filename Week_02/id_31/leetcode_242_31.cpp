#include <iostream>
#include <string>
#include <vector>
#include <functional>
#include <algorithm>
#include <iterator>

using namespace std;

/*
给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。

示例 1:

输入: s = "anagram", t = "nagaram"
输出: true
示例 2:

输入: s = "rat", t = "car"
输出: false
说明:
你可以假设字符串只包含小写字母。
*/



namespace version_1
{
    /*
    使用桶排序，如果两个词的桶排序一致的，说明就是异位词。否则，就不是异位词
    */

    class Solution {
    public: 

        bool isAnagram(string s, string t) {
            
            //加速判断
            if  ( ( s.empty() ) && ( t.empty() ) )
                return true;

            if  ( ( s.empty() ) && !( t.empty() ) )
                return false;

            if  ( !( s.empty() ) && ( t.empty() ) )
                return false;

            const char *sch = s.data();
            const char *tch = t.data();
            
            int scount[26] = {0};
            int tcount[26] = {0};

            //对s进行桶排序
            while(*sch)
            {
                scount[*sch -'a']++;
                sch++;
            }

            //对t进行桶排序
            while(*tch)
            {
                tcount[*tch -'a']++;
                tch++;
            }

            //判断两个桶排序是否一致
            for(int i=0;i<26;i++)
            {
                if (scount[i] != tcount[i])
                {
                    return false;
                }
            }

            //搜过完成，证明这两个桶排序是完全一样的。
            return true;   
        }
    };
}

using namespace version_1;

int main(int argc,char *argv[])
{
    Solution mytest;
    bool test1 = mytest.isAnagram("anagram","nagaram");
    bool test2 = mytest.isAnagram("rat","cat");
    return 0;
}