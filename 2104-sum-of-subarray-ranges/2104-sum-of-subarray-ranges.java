class Solution {
    public long subArrayRanges(int[] nums) {
        int n = nums.length;

        int[] NSE = new int[n];
        int[] PSE = new int[n];
        int[] NGE = new int[n];
        int[] PGE = new int[n];

        findNSE(nums, NSE);
        findPSE(nums, PSE);
        findNGE(nums, NGE);
        findPGE(nums, PGE);

        long total = 0;

        for (int i = 0; i < nums.length; i++) {
            int leftMax = i - PGE[i];
            int rightMax = NGE[i] - i;
            int leftMin = i - PSE[i];
            int rightMin = NSE[i] - i;

            long maxSum = leftMax * rightMax * 1L * nums[i];
            long minSum = leftMin * rightMin * 1L * nums[i];

            total = total + (maxSum - minSum);
        }

        return total;
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

            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }

            PSE[i] = st.isEmpty() ? -1 : st.peek();

            st.push(i);
            i++;
        }
    }

    public void findNGE(int[] arr, int[] NGE) {
        int n = arr.length;
        Deque<Integer> st = new ArrayDeque<>();
        int i = n - 1;

        while (i >= 0) {

            while(!st.isEmpty() && arr[st.peek()] < arr[i]) {
                st.pop();
            }

            NGE[i] = st.isEmpty() ? n : st.peek();

            st.push(i);
            i--;
        }
    }

    public void findPGE(int[] arr, int[] PGE) {
        int n = arr.length;
        Deque<Integer> st = new ArrayDeque<>();
        int i = 0;

        while (i < n) {

            while (!st.isEmpty() && arr[st.peek()] <= arr[i]) {
                st.pop();
            }

            PGE[i] = st.isEmpty() ? -1 : st.peek();

            st.push(i);
            i++;
        }
    }
}