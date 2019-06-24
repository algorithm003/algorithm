class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0) return 0;
        
        int cur = 0;
        for(int i = 0 ; i < nums.length ; i++){
            if(nums[i] != nums[cur]){
             cur++;
             nums[cur] = nums[i];
            }
        }
        return cur + 1;
    }
}
/*思路：
1、暴力解法，用两个变量进行存储，a存储中间值，b存储当前位置，a初始值为下标为0的数组元素值，b为0，for循环遍历数组，当发现数组值与变量值不同时，将当前数组值替换给a，数组下标为b+1的元素替换为a，b自增1，直到循环结束，返回b。
2、经过优化之后，发现可以不需要使用两个变量来中间存储，直接用下标进行交换即可。
*/