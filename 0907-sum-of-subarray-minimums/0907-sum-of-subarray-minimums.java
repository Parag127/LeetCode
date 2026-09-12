class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int[] NSE = new int[n];
        int[] PSE = new int[n];

        findNSE(arr, NSE);
        findPSE(arr, PSE);

        long minSum = 0;
        long mod = (long)(1e9 + 7);
        for (int i = 0; i < n; i++) {
            int left = i - PSE[i];
            int right = NSE[i] - i;

            minSum = (minSum + (left * right * 1L * arr[i]) % mod) % mod;
        }
        return (int)(minSum);
    }

    static void findNSE(int[] arr, int[] NSE) {
        int n = arr.length;
        int i = n - 1;
        Deque<Integer> st = new ArrayDeque<>();

        while (i >= 0) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }

            NSE[i] = st.isEmpty() ? n : st.peek();

            st.push(i);
            i--;
        }

    }

    static void findPSE(int[] arr, int[] PSE) {
        int n = arr.length;
        int i = 0;
        Deque<Integer> st = new ArrayDeque<>();

        while (i < n) {
            while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
                st.pop();
            }

            PSE[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
            i++;
        }
    }
}