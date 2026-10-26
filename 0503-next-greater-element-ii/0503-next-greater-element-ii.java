class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] nge = new int[nums.length];

        NGE(nums, nge);

        return nge;    
    }


    public void NGE(int[] arr, int[] NGE) {
        int n = arr.length;

        Deque<Integer> st = new ArrayDeque<>();
        int i = n * 2 - 1;

        while (i >= 0) {

            while (!st.isEmpty() && arr[i % n] >= st.peek()) {
                st.pop();
            }

            NGE[i % n] = st.isEmpty() ? -1 : st.peek();

            st.push(arr[i % n]);
            i--;
        }
    }
}