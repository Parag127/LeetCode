class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] NSE = new int[n];
        int[] PSE = new int[n];

        findNSE(heights, NSE);
        findPSE(heights, PSE);

        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            maxArea = Math.max(maxArea, (NSE[i] - PSE[i] - 1) * heights[i]);
        }
        return maxArea;
    }

    static void findNSE(int[] arr, int[] NSE) {
        int n = arr.length;
        Deque<Integer> st = new ArrayDeque<>();

        int i = arr.length - 1;
        while (i >= 0) {
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }

            NSE[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
            i--;
        }
    }

    static void findPSE(int[] arr, int[] PSE) {
        int n = arr.length;
        Deque<Integer> st = new ArrayDeque<>();
        int i = 0;

        while (i < n) {
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }

            PSE[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
            i++;
        }
    }
}