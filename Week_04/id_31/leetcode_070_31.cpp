#include <iostream>
#include <malloc.h>
/*
假设你正在爬楼梯。需要 n 阶你才能到达楼顶。

每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？

注意：给定 n 是一个正整数。

示例 1：

输入： 2
输出： 2
解释： 有两种方法可以爬到楼顶。
1.  1 阶 + 1 阶
2.  2 阶
示例 2：

输入： 3
输出： 3
解释： 有三种方法可以爬到楼顶。
1.  1 阶 + 1 阶 + 1 阶
2.  1 阶 + 2 阶
3.  2 阶 + 1 阶

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/climbing-stairs
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/
namespace vesion_1
{
	/*
	对于任何n>=3的输入，都可以分解为先走1步然后再走(n-1)步+先走2步然后再走(n-2)步。
因此可得： f(n) = f(n - 1) + f(n - 2), n>= 3
提交后发现超时，顺着递归执行我们发现很多已经获得的结果又重复计算了，并且对于值越小，计算的重复越多；
	*/
	class Solution {
	public:
		int climbStairs(int n) {

			if (n < 2)
			{
				return 1;
			}

			return climbStairs(n - 1) + climbStairs(n - 2);
		}
	};
}

namespace vesion_2
{
	/*
	把version_1版本变成非递归的形
	*/

	class Solution {
	public:
		int climbStairs(int n) {
			int num1 = 1;
			int num2 = 2;
			int tmp = 1;
			int i = 0;
			if (n < 3)
			{
				return n;
			}
			else
			{
				for (i = 0; i < n - 2; i++)
				{
					tmp = num1 + num2;
					num1 = num2;
					num2 = tmp;
				}
				return tmp;
			}
		}
	};
}

namespace vesion_3
{
	/*
	version_1改进，加上记忆法
	*/
	class Solution {
	public:
		int climb_stairs(int n, int * &m)
		{
			if (n < 0)
			{
				return 0;
			}
			
			if (n == 1)
			{
				return 1;
			}

			if (n == 2)
			{
				return 2;
			}


			if (m[n] != 0)
			{
				return m[n];
			}
			else
			{
				int tmp1 = climb_stairs(n - 1, m);
				int tmp2 = climb_stairs(n - 2, m);

				m[n - 1] = tmp1;
				m[n - 2] = tmp2;

				m[n] = tmp1 + tmp2;
			}

			return m[n];
		}
		int climbStairs(const int n) {
			int *value = NULL;
			value = new int[n+1];
			for (int i = 0; i < n+1; i++)
			{
				value[i] = 0;
			}
			int result = climb_stairs(n,value);
			delete [] value;

			return result;
		}
	};
}


using namespace vesion_3;

int main(int argc, char *argv[])
{
	Solution mytest;
	int test1 = mytest.climbStairs(4);
	return 0;
}