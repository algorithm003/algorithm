package Week_01.id_37;

/**
 * 类描述：
 * 创建人： Sun YongMeng
 * 创建时间：2019/6/17 15:45
 * 修改人：  Sun YongMeng
 * 修改时间：2019/6/17 15:45
 * 修改备注：
 * @author Symer
 */
public class LeetCode_26_37 {
    /**
     * 因为数组是排序号的数组,
     * 所以将数组依次前后对比是否相同,
     * 用个变量记录当前已重新放数据的索引下标,
     * 不相同就重新放入数组中下一个索引下标位置
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0){ return 0;}
        int i = 0,j = 1;
        for (; j < nums.length; j++) {
            if (nums[i] != nums[j]){
                i++;
                nums[i] = nums[j];
            }
        }
        return i+1;
    }
}
