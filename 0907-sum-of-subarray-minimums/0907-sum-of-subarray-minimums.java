class Solution {
    public int sumSubarrayMins(int[] arr) {
        int[] NSE = new int[arr.length]; 
        int[] PSE = new int[arr.length]; 

        findNSE(arr, NSE);
        findPSE(arr, PSE);

        long minSum = 0;
        long mod = (long)(1e9 + 7);

        for (int i = 0; i < arr.length; i++) {
            int left = i - PSE[i];
            int right = NSE[i] - i;

            long total = (right * left * 1L * arr[i]) % mod;
            minSum = (minSum + total) % mod;
        }

        return (int)(minSum);
    }


    public void findNSE(int[] arr, int[] NSE) {
        int n = arr.length;
        Deque<Integer> st = new ArrayDeque<>();

        int i = n - 1;
        while (i >= 0) {

            while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
                st.pop();
            }

            NSE[i] = st.isEmpty() ? n : st.peek();

            st.push(i);
            i--;
        }
    }

    public void findPSE(int[] arr, int[] PSE) {
        int n = arr.length;

        Deque<Integer> st = new ArrayDeque<>();
        int i = 0;

        while (i < n) {

            while (!st.isEmpty() && arr[st.peek()] >= arr[i]){
                st.pop();
            }

            PSE[i] = st.isEmpty() ? -1 : st.peek();

            st.push(i);
            i++;
        }
    }
}