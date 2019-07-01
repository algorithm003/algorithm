#include <iostream>
#include <vector>
#include <map>
#include <algorithm>
#include <functional>
#include <iterator>

using namespace std;
/*
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *
 * 示例:
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */

namespace version_1
{
    /*使用map*/
    class Solution {
    public:
        vector<int> twoSum(vector<int>& nums, int target) {
            vector<int>::iterator firstIrtVector = nums.begin();
            vector<int>::iterator endIrtVector = nums.end();

            vector<int> value;

            map<int,int> dictionaries;
            map<int,int>::iterator valueIrt;
            int diff = 0;

            //全部元素进入map，map的第一个参数是值，第二个参数是下标
            for(int i = 0;firstIrtVector != endIrtVector;++firstIrtVector)
            {
                dictionaries.insert(make_pair(*firstIrtVector,i));
                i++;
            }

            //用一个for，循环去枚举每一个元素。
            firstIrtVector = nums.begin();
            for(int i=0;firstIrtVector != endIrtVector;++firstIrtVector)
            {
                //计算差值
                diff = target - (*firstIrtVector);
                //根据差值，去查找map，看看是否存在
                valueIrt = dictionaries.find(diff);
                //如果找到。
                if (valueIrt != dictionaries.end())
                {
                    //判断是否重复下标
                    if (i != (*valueIrt).second)
                    {
                        //非重复下标，返回结果。
                        value.push_back(i);
                        value.push_back( (*valueIrt).second);
                        return value;
                    }
                }

                i++;
            }

            return value;
        }
    };
}

using namespace version_1;

int main() {
    Solution mytest;

    //下面是各种测试用例

    int arry [] = {2,7,11,15};
    vector<int> nums1(arry,arry+4);

    vector<int> test1 = mytest.twoSum(nums1,9);
    copy(test1.begin(),test1.end(),ostream_iterator<int>(cout, " "));
    cout<<endl;

    vector<int> test2 = mytest.twoSum(nums1,13);
    copy(test2.begin(),test2.end(),ostream_iterator<int>(cout, " "));
    cout<<endl;

    vector<int> test3 = mytest.twoSum(nums1,17);
    copy(test3.begin(),test3.end(),ostream_iterator<int>(cout, " "));
    cout<<endl;

    vector<int> test4 = mytest.twoSum(nums1,18);
    copy(test4.begin(),test4.end(),ostream_iterator<int>(cout, " "));
    cout<<endl;

    vector<int> test5 = mytest.twoSum(nums1,22);
    copy(test5.begin(),test5.end(),ostream_iterator<int>(cout, " "));
    cout<<endl;

    vector<int> test6 = mytest.twoSum(nums1,26);
    copy(test6.begin(),test6.end(),ostream_iterator<int>(cout, " "));
    cout<<endl;

    int arry2 [] = {3,2,4};
    vector<int> nums2(arry2,arry2+3);
    vector<int> test7 = mytest.twoSum(nums2,6);
    copy(test7.begin(),test7.end(),ostream_iterator<int>(cout, " "));
    cout<<endl;

    return 0;
}