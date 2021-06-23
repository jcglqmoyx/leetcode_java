import java.util.Stack;

class Solution84 {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] left = new int[n], right = new int[n];
        Stack<Integer> stk = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stk.isEmpty() && heights[stk.peek()] >= heights[i]) stk.pop();
            if (stk.isEmpty()) left[i] = -1;
            else left[i] = stk.peek();
            stk.push(i);
        }
        stk.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!stk.empty() && heights[stk.peek()] >= heights[i]) stk.pop();
            if (stk.isEmpty()) right[i] = n;
            else right[i] = stk.peek();
            stk.push(i);
        }
        int res = 0;
        for (int i = 0; i < n; i++) res = Math.max(res, heights[i] * (right[i] - left[i] - 1));
        return res;
    }
}