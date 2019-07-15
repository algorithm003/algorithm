import java.util.Arrays;

/**
 * @Auther hantao on 2019/7/12.
 * @Date 2019/7/12 23:47
 * @Description
 */
public class leetCode_455_13 {

    // cookie与小孩排序，有多少cookie就可以满足多少小孩（如果每个cookie大于小孩的胃口；从小到大查找，找到一个cookie大于小孩的胃，则加1）
    public int findContentChildren(int[] childs, int[] cookies) {

        Arrays.sort(childs);
        Arrays.sort(cookies);

        int child = 0;
        for (int cookie = 0;child < childs.length && cookie < cookies.length;cookie++){
            if (cookies[cookie] >= childs[child]){
                child++;
            }
        }

        return child;
    }

    public static void main(String[] args){

        int[] childs = new int[]{1,23,19,45};
        int[] cookies = new int[]{32,12,3,1};
        System.out.println(new leetCode_455_13().findContentChildren(childs,cookies));

    }
}
