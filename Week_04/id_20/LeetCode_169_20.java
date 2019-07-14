package com.panguang.cooltea.pglib;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
*        169. 求众数
*        给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
*        你可以假设数组是非空的，并且给定的数组总是存在众数。
*
*        链接：https://leetcode-cn.com/problems/majority-element/
*
*        学号：020
* */

public class LeetCode_169_20 {

    //方法一：暴力双循环, 超时了……所以不能作为答案……
    //时间复杂度：O(n²)
    //空间复杂度：O(1)
    public int majorityElement(int[] nums) {
        int result = nums[0];
        for (int i = 0; i < nums.length - 1; i++){
            result = nums[i];
            int count = 1;
            for (int j = i + 1; j < nums.length; j++){
                int temp = nums[j];
                if (result == temp){
                    if (++count > nums.length / 2) return result;
                }
            }
        }
        return result;
    }


    //方法二：利用哈希表保存计数
    //时间复杂度：O(n)
    //空间复杂度：O(n)
    public int majorityElement1(int[] nums) {
        int result = nums[0];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++){
            int num = nums[i];
            if (!map.containsKey(num)){
                map.put(num, 1);
            }else{
                map.put(num, map.get(num) +1);
            }
            if (map.get(num) > nums.length / 2){
                return num;
            }
        }
        return result;
    }


    //方法三：利用Java库函数排序，直接返回
    //时间复杂度：O(nlogn), Java 将数组排序开销都为 O(nlogn)
    //空间复杂度：O(n)
    public int majorityElement2(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }


    //方法四：分治
    //时间复杂度：O(nlogn)
    //空间复杂度：O(nlogn)
    private int countInArray(int[] nums, int des, int head, int last){
        int count = 0;
        for (int i = head; i <= last; i++){
            if (nums[i] == des) count++;
        }
        return count;
    }

    private int majorityElementDC(int[] nums, int head, int last) {
        if (head == last) return nums[head];
        int mid = head + (last - head) / 2;
        int left = majorityElementDC(nums, head, mid);
        int right = majorityElementDC(nums, mid + 1, last);
        if (left == right) return left;
        int leftCount = countInArray(nums, left, head, last);
        int rightCount = countInArray(nums, right, head, last);
        return leftCount > rightCount ? left : right;
    }

    public int majorityElement4(int[] nums) {
        return majorityElementDC(nums, 0, nums.length - 1);
    }


    //方法五：Boyer-Moore 投票算法.
    //Boyer-Moore 算法就是找 nums 的一个后缀 sufsuf ，其中 suf[0] 就是后缀中的众数。我们维护一个计数器，如果遇到一个我们目前的候选众数，就将计数器加一，否则减一。只要计数器等于 0 ，我们就将 nums 中之前访问的数字全部 忘记 ，并把下一个数字当做候选的众数。
    //时间复杂度：O(n)
    public int majorityElement5(int[] nums) {
        int count = 0;
        int result = nums[0];
        for (int i = 0; i < nums.length; i++){
            if (count == 0 ) result = nums[i];
            count += (nums[i] == result) ? 1 : -1;
        }
        return result;
    }

}
