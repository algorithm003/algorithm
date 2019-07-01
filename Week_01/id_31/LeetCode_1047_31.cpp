#include <iostream>
#include <string>
#include <vector>
#include <stack>
#include <queue>

using namespace std;

namespace version_1
{
    class Solution {
    public:
        string removeDuplicates(string S) {
            string reslut;

            if (S.length() == 1)
            {
                return S;
            }

            bool complete = false;
            stack<char> tmp_array;

            int top = -1;
            int i = 0;

            while (complete ==false)
            {
                tmp_array.push(S[0]);
                for(int i=1;i<S.length();i++)
                {
                    if (tmp_array.empty())
                    {
                        tmp_array.push(S[i]);
                    } else{
                        if(tmp_array.top()!=S[i])
                        {
                            tmp_array.push(S[i]);
                        }
                        else
                        {
                            tmp_array.pop();
                        }
                    }
                }
                complete = true;

                while (!tmp_array.empty())
                {
                    reslut.insert(0,1,tmp_array.top());
                    tmp_array.pop();
                }
            }
            return reslut;
        }
    };
}

namespace version_2
{
    class Solution {
    public:
        string removeDuplicates(string S) {
            string reslut;

            if (S.length() == 1) {
                return S;
            }

            stack<char> tmp_array;
            int i = 0;

            tmp_array.push(S[0]);
            reslut += S[0];
            for (int i = 1; i < S.length(); i++) {
                if (tmp_array.empty()) {
                    tmp_array.push(S[i]);
                    reslut += S[i];
                } else {
                    if (tmp_array.top() != S[i]) {
                        tmp_array.push(S[i]);
                        reslut += S[i];
                    } else {
                        tmp_array.pop();
                        reslut.erase(reslut.end() - 1);
                    }
                }
            }
        return reslut;
        }
    };
}

using namespace version_2;

int main()
{
    Solution mytest;
    string result1 = mytest.removeDuplicates("abbaca");
    string result2 = mytest.removeDuplicates("aa");
    string result3 = mytest.removeDuplicates("azxxzy");
    return 0;
}