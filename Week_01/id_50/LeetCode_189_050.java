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
public class LeetCode_189_050 {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LeetCode_189_050 solution = new LeetCode_189_050();
		int[] nums = {1,2};
		String[] strs = {"nozzle","punjabi","waterlogged","imprison","crux","numismatists"};
//		System.out.println(solution.removeDuplicates(nums));
		solution.rotate(nums, 1);	
//		System.out.println(solution.isAnagram("dgqztusjuu", "dqugjzutss"));
//		solution.groupAnagrams(strs);
//		System.out.println(solution.removeDuplicates("abbacaacdad"));
//		System.out.println(solution.removeOuterParentheses("(())(()(()))"));
//		System.out.println(solution.arrangeCoins(2147483647));
//		System.out.println(solution.myPow(2, 10));
	}

	public void rotate(int[] nums, int k) {
		k = k%nums.length;
		if( k<=0 ){
			return;
		}
        int val = 0;
        for(int i=0; i<(nums.length-k)/2; i++){
        	val=nums[i];
        	nums[i] = nums[nums.length-1-k-i];
        	nums[nums.length-1-k-i] = val;
        	
        }
        for(int i=nums.length-k; i<nums.length-k+k/2; i++){
        	val=nums[i];
        	nums[i] = nums[nums.length-1-(i-(nums.length-k))];
        	nums[nums.length-1-(i-(nums.length-k))] = val;
        }
        for(int i=0; i<(nums.length)/2; i++){
        	val=nums[i];
        	nums[i] = nums[nums.length-1-i];
        	nums[nums.length-1-i] = val;
//        	System.out.println(nums[i]);
        }
//        for(int i=0; i<nums.length; i++){
//        	System.out.println(nums[i]);        	
//        }
        return;
	}
}