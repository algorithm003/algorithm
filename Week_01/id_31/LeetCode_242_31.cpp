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

class Solution {
public:
    static int cmp ( const void *a , const void *b ) 
    { 
        return *(char *)a - *(char *)b; 
    }

    bool isAnagram(string s, string t) {
        
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

        while(*sch)
        {
            scount[*sch -'a']++;
            sch++;
        }

        while(*tch)
        {
            tcount[*tch -'a']++;
            tch++;
        }

        for(int i=0;i<26;i++)
        {
            if (scount[i] != tcount[i])
            {
                return false;
            }
        }

        return true;   
    }
};

int main(int argc,char *argv[])
{
    Solution mytest;
    bool test1 = mytest.isAnagram("anagram","nagaram");
    bool test2 = mytest.isAnagram("rat","cat");
    return 0;
}