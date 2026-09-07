class Solution {
    public long subArrayRanges(int[] arr) {
        int n = arr.length;

        int[] NSE = new int[n];
        int[] PSE = new int[n];
        int[] NGE = new int[n];
        int[] PGE = new int[n];

        findNSE(arr, NSE);
        findPSE(arr, PSE);
        findNGE(arr, NGE);
        findPGE(arr, PGE);

        long ans = 0;
        for (int i = 0; i < n; i++) {
            long sLeft = i - PSE[i];
            long sRight = NSE[i] - i;
            long lLeft = i - PGE[i];
            long lRight =  NGE[i] - i;

            long max = (lLeft * lRight * 1L * arr[i]);
            long min = (sLeft * sRight * 1L * arr[i]);
            ans = (ans + max - min);
        }

        return ans;
    }

    static void findNSE(int[] arr, int[] NSE) {
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        int i = n - 1;
        while (i >= 0) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }

            if (st.isEmpty()) {
                NSE[i] = n;
            } else {
                NSE[i] = st.peek();
            }

            st.push(i);
            i--;
        }
    }

    static void findPSE(int[] arr, int[] PSE) {
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        int i = 0;

        while (i < n) {
            while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
                st.pop();
            }

            if (st.isEmpty()) {
                PSE[i] = -1;
            } else {
                PSE[i] = st.peek();
            }

            st.push(i);
            i++;
        }
    }

    static void findNGE(int[] arr, int[] NGE) {
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        int i = n - 1;

        while (i >= 0) {
            while (!st.isEmpty() && arr[st.peek()] <= arr[i]) {
                st.pop();
            }

            if (st.isEmpty()) {
                NGE[i] = n;
            } else {
                NGE[i] = st.peek();
            }

            st.push(i);
            i--;
        }
    }

    static void findPGE(int[] arr, int[] PGE) {
	    int n = arr.length;
	    Stack<Integer> st = new Stack<>();
	    int i = 0;
	    
	    while (i < n) {
	        while (!st.isEmpty() && arr[st.peek()] < arr[i]) {
	            st.pop();
	        }
	        
	        if (st.isEmpty()) {
	            PGE[i] = -1;
	        } else {
	            PGE[i] = st.peek();
	        }
	        
	        st.push(i);
	        i++;
	    }
    }
}