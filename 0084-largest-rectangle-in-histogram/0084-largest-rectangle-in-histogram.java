class Solution {
    public int largestRectangleArea(int[] arr) {
        int n = arr.length;
        Deque<Integer> st = new ArrayDeque<>();

        int maxArea = -1;
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
                int el = st.peek();
                st.pop();

                int NSE = i;
                int PSE = st.isEmpty() ? -1 : st.peek();
                maxArea = Math.max(maxArea, arr[el] * (NSE - PSE - 1));
            }
            st.push(i);
        }

        while (!st.isEmpty()) {
            int el = st.peek();
            st.pop();

            int NSE = n;
            int PSE = st.isEmpty() ? -1 : st.peek();
            maxArea = Math.max(maxArea, arr[el] * (NSE - PSE - 1));
        }

        return maxArea;
    }
}