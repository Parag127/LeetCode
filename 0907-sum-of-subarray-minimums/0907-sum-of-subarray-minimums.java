class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;

        int[] NSE = new int[n];
        int[] PSE = new int[n];

        findNSE(arr, NSE);
        findPSE(arr, PSE);

        long mod = (int)(1e9 + 7);
        long ans = 0;
        for (int i = 0; i < arr.length; i++) {
            int left = i - PSE[i];
            int right = NSE[i] - i;

            ans = (ans + ((long)arr[i] * left % mod) * right % mod) % mod ;
        }

        return (int)ans;
    }

    static void findNSE(int[] arr, int[] NSE) {
        int i = arr.length - 1;
        Deque<Integer> st = new ArrayDeque<>();
        while (i >= 0) {

            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }

            if (st.isEmpty()) {
                NSE[i] = arr.length;
            } else {
                NSE[i] = st.peek();
            }
            st.push(i);
            i--;
        }
    }

    static void findPSE(int[] arr, int[] PSE) {
        Deque<Integer> st = new ArrayDeque<>();
        int i = 0;

        while (i < arr.length) {
            while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
                st.pop();
            }

            if (st.isEmpty()){
                PSE[i] = -1;
            } else {
                PSE[i] = st.peek();
            }

            st.push(i);
            i++;
        }
    }
}