class Solution {
public:
    /*
    思路：
    找到2个相同的字符，两个字符之间的长度为子字符长度，取得最大值。
    变量max存储最大值，两个指针i,j, i从0开始遍历到结尾，每次取出当前字符s[i]. j从0开始，
    每遇到与s[i]相同的字符时，赋值为前一个的下标值，(i-j)为距离，赋值给最大值max。
    代码中(i-j)+1是为了处理单个字节情况比如"a"，ij都是0，但结果应该是1。
    */
    int lengthOfLongestSubstring(string s) {
        map<char, int> dict;
        int max = 0, i = 0, j = 0;
        for (i = 0; i < s.length(); ++i) {
            char &c = s[i]; // 为了代码清晰
            if(dict.find(c) != dict.end()) {
                j = std::max(j, dict[c]+1);
            }
            dict[c] = i;
            max = std::max(max, i-j+1);
        }
        return max;
    }
};