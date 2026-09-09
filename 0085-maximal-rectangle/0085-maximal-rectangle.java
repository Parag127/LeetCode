class Solution {
    public int maximalRectangle(char[][] matrix) {
        int[] height = new int[matrix[0].length];

        int maxArea = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    height[j] += 1;
                } else {
                    height[j] = 0;
                }
            }
            maxArea = Math.max(maxArea, largestRectangle(height));
        }

        return maxArea;
    }

    public static int largestRectangle(int[] arr) {
        int n = arr.length;
        Stack<Integer> st = new Stack<>();

        int maxArea = 0;

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