import java.util.IllegalFormatCodePointException;

/**
 * @author: wck
 * @date: 2019/6/21 17:05
 * @description: 50.求x的n次幂
 */

public class LeetCode_50_36 {
    public static void main(String[] args) {
        System.out.println(result(2,11));
    }

    public static double result(double x,int n){
        double res = pow(x,Math.abs(n));
        return n>=0?res:1/res;
    }


    public static double pow(double x,int n){
        if (n==0)return 1;
        if (n==1) return x;
        double res = pow(x,n/2);//不断二分，分到1为止
        res  *= res;
        if (n%2 ==1)//如果是奇数，就自乘一下
            res *=x;
        return res;
    }
}
