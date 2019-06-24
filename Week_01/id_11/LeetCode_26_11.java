/**
 * 题目： 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array
 */
class Solution {
    /**
     * 思考：1.通过快慢指针，当两指针值相同的时候，就回产生位移变化 2.当值不同时，就对慢指针的下一个值赋值，以此来产生移除重复值的操作
     * 3.认真审题，没注意到有序数组浪费了些时间
     * 
     */
    public int removeDuplicates(int[] nums) {
        int i = nums.length > 0 ? 1 : 0;
        for (int n : nums) {
            if (n != nums[i - 1]) {
                nums[i++] = n;
            }
        }
        return i;
    }
}