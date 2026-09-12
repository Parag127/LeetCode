class Solution {
    public int maximalRectangle(char[][] matrix) {
        int[] heights = new int[matrix[0].length];
        int maxArea = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    heights[j] += 1;
                } else {
                    heights[j] = 0;
                }
            }

            maxArea = Math.max(maxArea, findLargestRectangle(heights));
        }
        return maxArea;
    }

    static int findLargestRectangle(int[] arr) {
        int n = arr.length;
        Deque<Integer> st = new ArrayDeque<>();
        int maxArea = 0;
        int i = 0;

        while(i < n) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                int el = st.pop();
                int NSE = i;
                int PSE = st.isEmpty() ? -1 : st.peek();

                maxArea = Math.max(maxArea, (NSE - PSE - 1) * arr[el]);
            }
            st.push(i);
            i++;
        }

        while (!st.isEmpty()) {
            int el = st.pop();
            int NSE = i;
            int PSE = st.isEmpty() ? -1 : st.peek();
            maxArea = Math.max(maxArea, (NSE - PSE - 1) * arr[el]);
        }
        return maxArea;
    }
}