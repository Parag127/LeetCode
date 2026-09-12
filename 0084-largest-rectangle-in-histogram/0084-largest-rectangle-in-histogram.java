class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int i = 0;
        int maxArea = 0;
        Deque<Integer> st = new ArrayDeque<>();
        while (i < n) {
            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                int el = st.peek();
                st.pop();
                int NSE = i;
                int PSE = st.isEmpty() ? -1 : st.peek();

                maxArea = Math.max(maxArea, (NSE - PSE - 1) * heights[el]);
            }
            st.push(i);
            i++;
        }

        while (!st.isEmpty()) {
            int el = st.peek();
            st.pop();
            int NSE = i;
            int PSE = st.isEmpty() ? -1 : st.peek();
            maxArea = Math.max(maxArea, (NSE - PSE - 1) * heights[el]);
        }
        return maxArea;
    }
}