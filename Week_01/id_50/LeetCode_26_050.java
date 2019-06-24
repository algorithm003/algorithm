import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;



/**
 * @author yu
 *  删除排序数组中的重复项
 */
public class LeetCode_26_050 {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LeetCode_26_050 solution = new LeetCode_26_050();
		int[] nums = {1,2};
		System.out.println(solution.removeDuplicates(nums));
	}

	public int removeDuplicates(int[] nums) {
		int n = 0;
		for(int i=0; i<nums.length; i++){
			for(int j=0; j<=n; j++){
				if(i==0){
//					System.out.println(nums[i]);
					n++;
					break;
				}
				if(nums[i]==nums[j]){
					break;
				}else{
					if(j==(n-1)){
						nums[n]=nums[i];
//						System.out.println(nums[i]);
						n++;
					}
				}
			}
		}
        return n;
    }
}