/**
 * Created by hantao on 2019/6/15.
 */
public class LeetCode_26_13 {

    // 慢数组记录不重复的值，下标+1 为数组的长度；快数组寻找不同的值，每找到一个不同的值，则慢数组加+1,然后将慢数组对应的值替换为对应的快数组的值
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0) return 0;
        int i = 0;
        for (int j=1;j < nums.length;j++){
            if ( nums[j] != nums[i]){
                i++;
                nums[i] = nums[j];
            }
        }

        return i+1;
    }


    // 选择排序 pre记录非重复最后一个下标，find下标查找非重复下标
    public int removeDuplicates2(int[] nums) {
        if(nums.length == 0) return 0;
        int pre =0;int find =1;
        while(find < nums.length)
        {
            if (nums[find] != nums[pre])
            {
                pre++;
                nums[pre] = nums[find];
            }
            find ++;

        }


        return pre+1;
    }

    public static void main(String[] args) throws InterruptedException {
        LeetCode_26_13 test = new LeetCode_26_13();
        int[] nums = new int[]{1,1,3,3,4,5};
        //int len = sol.removeDuplicates(nums);
        int len = test.removeDuplicates2(nums);
        for(int i = 0;i<len;i++){
            System.out.print(" "+nums[i]);
        }

        System.out.println();
        for(int i = 0;i<nums.length;i++){
            System.out.print(" "+nums[i]);
        }

    }
}
