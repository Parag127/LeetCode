class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] NGT = new int[n];
        return findNGT(temperatures, NGT); 
    }


    static int[] findNGT(int[] arr, int[] NGE) {
        int n = arr.length;
        Deque<Integer> st = new ArrayDeque<>();
        int i = n - 1;

        while (i >= 0) {
            while (!st.isEmpty() && arr[st.peek()]  <= arr[i]){
                st.pop();
            }

            NGE[i] = st.isEmpty() ? 0 : st.peek() - i;
            st.push(i);
            i--;
        }
        return NGE;
    }
}