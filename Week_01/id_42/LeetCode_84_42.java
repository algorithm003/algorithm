package geek;
import java.util.Stack;

class Solution84 {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length < 1)
            return 0;

        Stack<Integer> stack = new Stack<Integer>();
        stack.push(-1);
        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            while (stack.peek() != -1 && heights[i] < heights[stack.peek()]) {
                int top = stack.pop();
                max = Math.max(max, (i - 1 - stack.peek()) * heights[top]);
            }
            stack.push(i);
        }
        while (stack.peek() != -1) {
            int top = stack.pop();
            max = Math.max(max, (heights.length - 1 - stack.peek()) * heights[top]);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] heights = {2,1,5,6,2,3};
        Solution84 solution84 = new Solution84();
        int max = solution84.largestRectangleArea(heights);
        System.out.println(max);
    }
}