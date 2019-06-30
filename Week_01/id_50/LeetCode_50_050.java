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
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 */
public class LeetCode_50_050 {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LeetCode_50_050 solution = new LeetCode_50_050();
		System.out.println(solution.myPow(2, 10));
	}

	private double calPow(double x, int n) {
		if(n==0){
			return 1;
		}
		double half = calPow(x, n/2);
		if(n%2 == 0){
			return half*half;
		}else{
			return half*half*x;
		}
	}
	public double myPow(double x, int n) {
		if(n==0){
			return 1;
		}
		if(n>0){
			return calPow(x, n);
		}else{
			return 1/calPow(x, Math.abs(n));
		}
	}
}