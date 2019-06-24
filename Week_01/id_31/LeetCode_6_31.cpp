#include <iostream>
#include <vector>
#include <set>
#include <algorithm>

using namespace std;

/*
给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。

注意：答案中不可以包含重复的三元组。

例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，

满足要求的三元组集合为：
[
  [-1, 0, 1],
  [-1, -1, 2]
]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/3sum
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/

namespace vesion_1
{
	class Solution {
	public:
		vector<vector<int>> threeSum(vector<int>& nums) {

			vector<vector<int>> result;

			if (nums.empty())
				return result;

			multiset<int> diff;
			
			int size = nums.size();

			if (size < 3)
				return result;

			for (int i=0;i<size;i++)
			{
				diff.insert(nums[i]);
			}

			
			set<multiset<int>> only_once_time;

			int zero_count = count(diff.begin(), diff.end(), 0);

			if (zero_count>=3)
			{
				multiset<int> one_time;
				one_time.insert(0);
				one_time.insert(0);
				one_time.insert(0);
				only_once_time.insert(one_time);

				vector<int> value;
				value.push_back(0);
				value.push_back(0);
				value.push_back(0);

				result.push_back(value);

				for (int i = 0; i < zero_count - 1; i++)
				{
					diff.erase(diff.find(0));
				}
			}

			for (int i = 0; i < size; i++)
			{
				for (int j = i + 1; j < size; j++)
				{
					int zero_sub = 0 - (nums[i] + nums[j]);

					if ( ((zero_sub == nums[i]) || (zero_sub == nums[j])) &&(zero_sub != 0))
					{
						continue;
					}

					if ( ( diff.find(zero_sub) != diff.end() ) )
					{
						if (((zero_sub == nums[i]) || (zero_sub == nums[j])) && (zero_sub == 0))
						{
							continue;
						}

						multiset<int> one_time;
						one_time.insert(nums[i]);
						one_time.insert(nums[j]);
						one_time.insert(zero_sub);

						if (only_once_time.find(one_time) == only_once_time.end())
						{
							only_once_time.insert(one_time);

							vector<int> value;
							value.push_back(nums[i]);
							value.push_back(nums[j]);
							value.push_back(zero_sub);

							result.push_back(value);
						}
					}
				}
			}

			return result;
		}
	};
}

namespace vesion_2
{
	//ok 724ms
	class Solution {
	public:
		vector<vector<int>> threeSum(vector<int>& nums) {
			int size = nums.size();

			vector<vector<int>> result;

			if (size < 3)
				return result;

			sort(nums.begin(), nums.end());

			set<multiset<int>> only_once_time;

			int zero_count = count(nums.begin(), nums.end(), 0);


			if (zero_count>=3)
			{
				multiset<int> one_time;
				one_time.insert(0);
				one_time.insert(0);
				one_time.insert(0);
				only_once_time.insert(one_time);

				vector<int> value;
				value.push_back(0);
				value.push_back(0);
				value.push_back(0);

				result.push_back(value);

				for (int i = 0; i < zero_count - 1; i++)
				{
					nums.erase(find(nums.begin(),nums.end(),0));
				}
			}

			size = nums.size();

			if (size < 3)
				return result;

			for (int a_index =0;a_index<size-2;a_index++)
			{
				int b_index = a_index + 1;
				int c_index = size - 1;

				while (b_index < c_index)
				{
					if ((nums[a_index] + nums[b_index] + nums[c_index]) == 0)
					{

						multiset<int> one_time;
						one_time.insert(nums[a_index]);
						one_time.insert(nums[b_index]);
						one_time.insert(nums[c_index]);

						if (only_once_time.find(one_time) == only_once_time.end())
						{
							only_once_time.insert(one_time);

							vector<int> value;
							value.push_back(nums[a_index]);
							value.push_back(nums[b_index]);
							value.push_back(nums[c_index]);

							result.push_back(value);
						}
						b_index++;
					}
					else
					{
						if ((nums[a_index] + nums[b_index] + nums[c_index]) > 0)
						{
							c_index--;
						}
						else
						{
							b_index++;
						}
					}
				}
			}

			return result;
		}
	};
}

namespace vesion_3
{
	//ok 408ms
	class Solution {
	public:
		vector<vector<int>> threeSum(vector<int>& nums) {
			int size = nums.size();

			vector<vector<int>> result;

			if (size < 3)
				return result;

			sort(nums.begin(), nums.end());

			size = nums.size();

			if (size < 3)
				return result;

			set<multiset<int>> only_once_time;

			for (int a_index = 0; a_index < size - 2; a_index++)
			{
				int b_index = a_index + 1;
				int c_index = size - 1;

				while (b_index < c_index)
				{
					if ((nums[a_index] + nums[b_index] + nums[c_index]) == 0)
					{

						multiset<int> one_time;
						one_time.insert(nums[a_index]);
						one_time.insert(nums[b_index]);
						one_time.insert(nums[c_index]);

						if (only_once_time.find(one_time) == only_once_time.end())
						{
							only_once_time.insert(one_time);

							vector<int> value;
							value.push_back(nums[a_index]);
							value.push_back(nums[b_index]);
							value.push_back(nums[c_index]);

							result.push_back(value);
						}

						while (nums[b_index+1]==nums[b_index])
						{
							b_index++;

							if (b_index >= c_index)
							{
								break;
							}
						}

						if (b_index >= c_index)
						{
							break;
						}

						b_index++;
					}
					else
					{
						if ((nums[a_index] + nums[b_index] + nums[c_index]) > 0)
						{
							while (nums[c_index - 1] == nums[c_index])
							{
								c_index--;

								if (b_index >= c_index)
								{
									break;
								}
							}

							if (b_index >= c_index)
							{
								break;
							}

							c_index--;
						}
						else
						{
							while (nums[b_index + 1] == nums[b_index])
							{
								b_index++;

								if (b_index >= c_index)
								{
									break;
								}
							}

							if (b_index >= c_index)
							{
								break;
							}

							b_index++;
						}
					}
				}
			}

			return result;
		}
	};
}

using namespace vesion_3;

int main(int argc, char *argv[])
{
	Solution mytest;
	vector<int> test1{ -1, 0, 1, 2, -1, -4 };
	vector<vector<int>> result1 = mytest.threeSum(test1);

	vector<int> test2{0,0,0};
	vector<vector<int>> result2 = mytest.threeSum(test2);

	vector<int> test3{ -1,0,1,0 };
	vector<vector<int>> result3 = mytest.threeSum(test3);

	vector<int> test4{ -2,0,1,1,2 };
	vector<vector<int>> result4 = mytest.threeSum(test4);

	vector<int> test5{ -1,0,1,2,-1,-4 };
	vector<vector<int>> result5 = mytest.threeSum(test5);

	return 0;
}
