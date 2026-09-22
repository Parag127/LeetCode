class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] NWT = new int[temperatures.length];
        return findNWT(temperatures, NWT);
    }

    static int[] findNWT(int[] arr, int[] NGE) {
        int n = arr.length;
        int i = n - 1;

        Deque<Integer> st = new ArrayDeque<>();
        while (i >= 0) {
            while (!st.isEmpty() && arr[st.peek()] <= arr[i]) {
                st.pop();
            }

            NGE[i] = st.isEmpty() ? 0 : st.peek() - i;

            st.push(i);
            i--;
        }
        return NGE;
    }
}