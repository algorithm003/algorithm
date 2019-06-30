/*
*
*   189. 旋转数组
*   给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
*
*   学号：020
*
* */

class Solution {


    //方法一：循环 k 次，从数组最后元素开始操作，逐一将最后一个元素移到数组最前面。
    public void rotate1(int[] nums, int k) {
        k %= nums.length;   //保证 k 在数组长度内。
        for (int i = 0; i < k; i++) {
            int temp = nums[nums.length - 1];   //临时变量保存数组最后一个元素
            for (int j = nums.length - 1; j > 0; j--) {
                nums[j] = nums[j - 1];      //从数组最后开始操作，将数组元素逐一往后移。
            }
            nums[0] = temp;     //最后一个元素放数组第一个位置。
        }
    }


    //方法二：原理同上，只是移动操作从数组最前元素开始，优化的代码相对更简洁一些。
    public void rotate2(int[] nums, int k) {
        for (int i = 0; i < ( k % nums.length ); i++) {
            int previous = nums[nums.length - 1];
            for (int j = 0; j < nums.length; j++) {
                int temp = nums[j];
                nums[j] = previous;
                previous = temp;
            }
        }
    }


    //方法三：三次反转数组
    public void rotate3(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums, 0, nums.length - 1);      //第一次先将整个数组反转，将后 k 个元素，从数组最后部分移到数组最前部分
        reverse(nums, 0, k - 1);                //第二次反转，将前 k 个元素顺序反转为原来的顺序
        reverse(nums, k, nums.length - 1);            //第三次反转，将剩下的元素反转位原来的顺序
    }

    //反转数组函数
    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }


}