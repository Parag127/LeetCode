class Solution {
    public int trap(int[] height) {
        int n = height.length;

        if (n <= 2) return 0;

        int[] prefix = new int[n];
        int[] suffix = new int[n];

        prefixMax(prefix, height, n);
        suffixMax(suffix, height, n);

        int ans = 0;
        for (int i = 0; i < n; i++) {
            int leftMax = prefix[i];
            int rightMax = suffix[i];

            ans += Math.min(leftMax, rightMax) - height[i];
        }        
        return ans;
    }

    public static void prefixMax(int[] prefix, int[] arr, int n){
        prefix[0] = arr[0];

        for (int i = 1; i < n; i++) {
            prefix[i] = Math.max(prefix[i - 1], arr[i]);
        }
    }

    public static void suffixMax(int[] suffix, int[] arr, int n){
        suffix[n - 1] = arr[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            suffix[i] = Math.max(suffix[i + 1], arr[i]);
        }
    }
}