#include <iostream>
#include <vector>
#include <map>
#include <string>
#include <utility>
#include <algorithm>
#include <functional>
#include <iterator>

using namespace std;

/*
给一非空的单词列表，返回前 k 个出现次数最多的单词。

返回的答案应该按单词出现频率由高到低排序。如果不同的单词有相同出现频率，按字母顺序排序。

示例 1：

输入: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
输出: ["i", "love"]
解析: "i" 和 "love" 为出现次数最多的两个单词，均为2次。
    注意，按字母顺序 "i" 在 "love" 之前。
 

示例 2：

输入: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
输出: ["the", "is", "sunny", "day"]
解析: "the", "is", "sunny" 和 "day" 是出现次数最多的四个单词，
    出现次数依次为 4, 3, 2 和 1 次。
 

注意：

假定 k 总为有效值， 1 ≤ k ≤ 集合元素数。
输入的单词均由小写字母组成。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/top-k-frequent-words
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

namespace version_1
{
    class Solution {
        public:
        struct CmpByValue {
            bool operator()(const pair<string,int>& p1, const pair<string,int>& p2) {
                if (p1.second > p2.second)
                    return true;
                if (p1.second == p2.second) {
                    if (p1.first < p2.first)
                        return true;
                }
                return false;
            }
        };

        vector<string> topKFrequent(vector<string>& words, int k) {
            
            //第一个是单词，第二个是统计次数
            map<string,int> count_map;
            
            //统计单词出现的频率
            for(size_t i = 0; i < words.size(); i++)
            {
                string s = words[i];

                if (count_map.find(s) == count_map.end())
                {
                    count_map.insert(make_pair(s,1));
                } else{
                    count_map[s]++;
                }
            }

            //按值排序，降序
            vector< pair<string,int> > name_score_vec(count_map.begin(), count_map.end());
            sort(name_score_vec.begin(), name_score_vec.end(), CmpByValue());

            //把降序的前面k个，做返回
            vector<string> result;
            for (size_t i = 0; i < k && i<name_score_vec.size(); i++)
            {
                result.push_back(name_score_vec[i].first);
            }
            
            return result;
        }
    };
}

using namespace version_1;

int main(int argc,char *argv[])
{
    //以下是测试用例，并打印。
    Solution mytest;
    string test_word1 [] = {"akjkun","hobievq","ibbb","jhw","pxwsurrun","hxfwhrjm","pxwsurrun","wjo","pxwsurrun","wfetx","ydp","qfazmji","qfazmji","llvabr","uaq","kyj","uaq","wuzvu","nze","qznvdw","wjo","uaq","qfazmji","uaq","hxfwhrjm","ftmcuyb","rmjim","omx","omx","jgqdwle","ehoc","nze","jgqdwle","kyj","erkc","wfetx","wjo","wjo","rmldehuuff","wfetx","qznvdw","jhw","jhw","pxwsurrun","rmldehuuff","omx","yhriclj","pxwsurrun","kyj","erkc","wfetx","pxwsurrun","gukcclzd","llvabr","cpgyk","jhw","llvabr","qfazmji","llvabr","yhriclj","zvefqcz","fiwdfgzs","pqpozde","nze","qfazmji","qznvdw","kyj","ydp","wuzvu","erkc","qznvdw","yhriclj","akjkun","rmjim","moeuarod","hvxg","nze","rmldehuuff","jhw","rmldehuuff","wjo","cpgyk","omx","hlak","kyj","hxfwhrjm","qfazmji","gukcclzd","pqpozde","wfetx","wahno","cpgyk","nze","ibbb","wjo","wuzvu","kyj","kyj","zvefqcz","rmjim","erkc","llvabr","omx","hobievq","pxwsurrun","wahno","akjkun","jgqdwle","nze","ftmcuyb","wuzvu","hxfwhrjm","ibbb","wfetx","akjkun","omx","hxfwhrjm","hlak","rmldehuuff","hxfwhrjm","jhw","pxwsurrun","omx","wjo","hlak","zvefqcz","ehoc","wuzvu","pqpozde","cgwncxeof","jhw","hlak","usaq","wqnez","qznvdw","ibbb","erkc","wfetx","hlak","cpgyk","hxfwhrjm","wuzvu","jaar","hlak","wahno","hlak","ibbb","nze","omx","wfetx","erkc","kyj","pqpozde","hlak","nze","wjo","cgwncxeof","uaq","kyj","wahno","cgwncxeof","hlak","rmldehuuff","hlak","wfetx","wahno","kyj","yhriclj","nze","jgqdwle","fiwdfgzs","jhw","wuzvu","wfetx","ibbb","ydp","hobievq","rmjim","ehoc","jhw","hobievq","rmldehuuff","wuzvu","gukcclzd","wuzvu","jhw","qfazmji","wjo","qfazmji","wuzvu","ehoc","omx","nze","jgqdwle","pxwsurrun","omx","gukcclzd","jaar","uaq","qznvdw","ibbb","hxfwhrjm"};
    vector<string> test1 (test_word1,test_word1+(sizeof(test_word1)/sizeof(test_word1[0])));
    vector<string> result1 = mytest.topKFrequent(test1,24);

    copy(result1.begin(),result1.end(),ostream_iterator<string>(cout, " "));
    cout<<endl<<endl;

    string test_word2 [] = {"glarko","zlfiwwb","nsfspyox","pwqvwmlgri","qggx","qrkgmliewc","zskaqzwo","zskaqzwo","ijy","htpvnmozay","jqrlad","ccjel","qrkgmliewc","qkjzgws","fqizrrnmif","jqrlad","nbuorw","qrkgmliewc","htpvnmozay","nftk","glarko","hdemkfr","axyak","hdemkfr","nsfspyox","nsfspyox","qrkgmliewc","nftk","nftk","ccjel","qrkgmliewc","ocgjsu","ijy","glarko","nbuorw","nsfspyox","qkjzgws","qkjzgws","fqizrrnmif","pwqvwmlgri","nftk","qrkgmliewc","jqrlad","nftk","zskaqzwo","glarko","nsfspyox","zlfiwwb","hwlvqgkdbo","htpvnmozay","nsfspyox","zskaqzwo","htpvnmozay","zskaqzwo","nbuorw","qkjzgws","zlfiwwb","pwqvwmlgri","zskaqzwo","qengse","glarko","qkjzgws","pwqvwmlgri","fqizrrnmif","nbuorw","nftk","ijy","hdemkfr","nftk","qkjzgws","jqrlad","nftk","ccjel","qggx","ijy","qengse","nftk","htpvnmozay","qengse","eonrg","qengse","fqizrrnmif","hwlvqgkdbo","qengse","qengse","qggx","qkjzgws","qggx","pwqvwmlgri","htpvnmozay","qrkgmliewc","qengse","fqizrrnmif","qkjzgws","qengse","nftk","htpvnmozay","qggx","zlfiwwb","bwp","ocgjsu","qrkgmliewc","ccjel","hdemkfr","nsfspyox","hdemkfr","qggx","zlfiwwb","nsfspyox","ijy","qkjzgws","fqizrrnmif","qkjzgws","qrkgmliewc","glarko","hdemkfr","pwqvwmlgri"};
    vector<string> test2 (test_word2,test_word2+(sizeof(test_word2)/sizeof(test_word2[0])));
    vector<string> result2 = mytest.topKFrequent(test2,14);

    copy(result2.begin(),result2.end(),ostream_iterator<string>(cout, " "));
    cout<<endl<<endl;

    return 0;
}