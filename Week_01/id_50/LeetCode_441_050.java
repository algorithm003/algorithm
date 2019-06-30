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
 * 排列硬币
 */
public class LeetCode_441_050 {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LeetCode_441_050 solution = new LeetCode_441_050();
		System.out.println(solution.arrangeCoins(2147483647));
	}

	public int arrangeCoins(int n) {
        if(n<=0){
			return 0;
		}
		long i=1;
		for (; i<=(n/2+1);i++){
			long val = ((1+i)*i)/2;
			if(val<=n){
				continue;
			}else{
				break;
			}
		}
		i--;
		return Integer.valueOf(""+i);
    }
}