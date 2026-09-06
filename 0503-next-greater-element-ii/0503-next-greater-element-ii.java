class Solution {
    public int[] nextGreaterElements(int[] nums) {
        
        Deque<Integer> st = new ArrayDeque<>();
        int n = nums.length;
        int i = n * 2 - 1;
        int[] nge = new int [n];

        while (i >= 0) {
            
            while (!st.isEmpty() && st.peek() <= nums[i % n]) {
                st.pop();
            }

            if (i < n) {
                nge[i] = st.isEmpty() ? -1 : st.peek();
            }
            st.push(nums[i % n]);
            i--;
        }

        return nge;
    }
}