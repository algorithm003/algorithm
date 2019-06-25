#include <iostream>
#include <string>
#include <stack>

using namespace std;



class Solution {
public:
    string removeOuterParentheses(string S) {
        char left = '(';
        char right = ')';

        string result;
        stack<char> tmp_stack1;
        for (int i = 0; i <S.length() ; ++i) {
            if (tmp_stack1.empty()) {
                tmp_stack1.push(S[i]);
            } else {
                if  (S[i]=='('){
                    tmp_stack1.push(S[i]);
                    result += S[i];
                } else if ((tmp_stack1.top() == '(') && (S[i] == ')')) {
                    tmp_stack1.pop();
                    if (! tmp_stack1.empty() )
                    {
                        result += S[i];
                    }
                } else {
                    result += S[i];
                }
            }
        }
        return result;
    }
};


int main() {
    Solution mytest;
    string test1 = mytest.removeOuterParentheses("(()())(())");
    cout<<test1<<endl;
    string test2 = mytest.removeOuterParentheses("((()))");
    cout<<test2<<endl;
    std::cout << "Hello, World!" << std::endl;
    return 0;
}