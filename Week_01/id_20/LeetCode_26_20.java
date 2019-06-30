/*
*
*    26. 删除排序数组中的重复项
*    给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
*    不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
*
*   学号：020
*
* */


class Solution {
    public int removeDuplicates(int[] nums) {

        int newCount = 0;   //数组的新索引

        for (int i=0; i< nums.length; i++) {
            if ( i == 0 || nums[i] != nums[i-1] ) {
                nums[newCount] = nums[i];   //当前值和前值不相等，则将当前值填充在新索引对应的新位置。
                newCount += 1;
            }
        }
        return newCount;
    }
}