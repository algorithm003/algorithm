package src;

public class Solution {
    public int trap(int[] height) {
        if (height.length <= 2) {
            return 0;
        }

        int i, result = 0;
        int len = height.length;
        int[] left = new int[len];
        int[] right = new int[len];
        for (i = 1; i < len; i++) {
            left[i] = Math.max(left[i - 1], height[i - 1]);
            right[len - i - 1] = Math.max(right[len - i], height[len - i]);
        }
        for (i = 0; i < len; i++) {
            if (left[i] > height[i] && height[i] < right[i]) {
                result += Math.min(left[i], right[i]) - height[i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(solution.trap(height));

    }
}
