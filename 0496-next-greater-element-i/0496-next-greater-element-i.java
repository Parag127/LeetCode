class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] nge = new int[nums2.length];

        NGE(nums2, nge);

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums2.length; i++) {
            map.put(nums2[i], i);
        }

        int[] ans = new int[nums1.length];

        for (int i = 0; i < nums1.length; i++) {
            if (map.containsKey(nums1[i])) {
                int el = map.get(nums1[i]);
                ans[i] = nge[el];
            } else {
                ans[i] = -1;
            }
        }
        
        return ans;

        
    }

    public void NGE (int[] arr, int[] NGE) {
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        int i = n - 1;
        while (i >= 0) {

            while (!st.isEmpty() && arr[i] > st.peek()) {
                st.pop();
            }

            NGE[i] = st.isEmpty() ? -1 : st.peek();

            st.push(arr[i]);
            i--;
        }
    }
}