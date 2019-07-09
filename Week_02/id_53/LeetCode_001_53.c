
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
 *
 * https://leetcode-cn.com/problems/two-sum
 */

/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
# include <malloc.h>
int* twoSum(int* nums, int numsSize, int target, int* returnSize){
	int *indics = (int *)malloc( 2 * sizeof(int));
    *returnSize = 2;
	for( indics[0]=0; indics[0]<numsSize; indics[0]++)
		for( indics[1]=indics[0]+1; indics[1]<numsSize; indics[1]++)
			if ( nums[indics[0]] + nums[indics[1]] == target )
				return indics;
	return NULL;
}
