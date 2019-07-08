package week3;

/**
 * @ author: Suhb
 * @ date: 2019/7/1 22:18
 * @ description: 双指针：11. 盛最多水的容器
 */
public class LeetCode_11_035 {
    /*给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
    在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
    找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
    说明：你不能倾斜容器，且 n 的值至少为 2。
    图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
    示例:
        输入: [1,8,6,2,5,4,8,3,7]
        输出: 49*/
    private int maxArea(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int length = height.length;
        int left = 0, right = length - 1, maxValue = 0;
        while (left < right) {  // 结束条件
            //水桶原则，最大面积，等于左右最小的高度再乘以长度
            maxValue = Math.max(maxValue, Math.min(height[left], height[right]) * (right - left));
            if (height[right] > height[left]) { // 如果右边的高度大于左边，那左边的就右移，反之，左移
                left++;
            } else {
                right --;
            }
        }
        return maxValue;
    }

    public static void main(String[] args) {
        LeetCode_11_035 leetCode_11_035 = new LeetCode_11_035();
        int[] height = new int[]{1,8,6,2,5,4,8,3,7};
        int result = leetCode_11_035.maxArea(height);
        System.out.println(result);
    }
}
