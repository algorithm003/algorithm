#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
#include <iterator>

using namespace std;

/*
 * 给定一个字符串S，通过将字符串S中的每个字母转变大小写，我们可以获得一个新的字符串。返回所有可能得到的字符串集合。

示例:
输入: S = "a1b2"
输出: ["a1b2", "a1B2", "A1b2", "A1B2"]

输入: S = "3z4"
输出: ["3z4", "3Z4"]

输入: S = "12345"
输出: ["12345"]
注意：

S 的长度不超过12。
S 仅由数字和字母组成。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/letter-case-permutation
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */
namespace version_1
{
    class Solution {
    public:
        void Permutation(const char * S,int length,int pos,vector<string>& ans,string &str){

            //如果到未尾，则保存结果。
            if (length == pos){
                ans.push_back(str);
                return;
            }

            //原有的字符不变。
            string tmpChar;
            tmpChar.push_back(S[pos]);
            tmpChar = str + tmpChar;
            Permutation(S,length,pos+1,ans,tmpChar);

            //如果小写变大写。如果大写变小写。
            if ((S[pos]>='a')&&(S[pos]<='z')){
                string upper;
                upper.push_back((S[pos]-'a'+'A'));
                upper = str+upper;
                Permutation(S,length,pos+1,ans,upper);
            } else if ((S[pos]>='A')&&(S[pos]<='Z')){
                string letter;
                letter.push_back((S[pos]-'A'+'a'));
                letter = str+letter;
                Permutation(S,length,pos+1,ans,letter);
            }
        }

        vector<string> letterCasePermutation(string S) {
            vector<string> ans;

            if (S.empty()){
                ans.push_back("");
                return ans;
            }
            string str = "";
            Permutation(S.data(),S.length(),0,ans,str);

            return ans;
        }
    };
}

using namespace version_1;

int main() {
    Solution mytest;
    vector<string> result1 = mytest.letterCasePermutation("a1b2");
    copy(result1.begin(),result1.end(),ostream_iterator<string>(cout,","));
    return 0;
}