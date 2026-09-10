class Solution {
    public int maxArea(int[] arr) {
        if (arr.length <= 1) return 0;
        int l = 0;
        int r = arr.length - 1;
        int maxArea = 0;

        while (l < r) {
            int width = r - l;
            int height = Math.min(arr[l], arr[r]);

            maxArea = Math.max(maxArea, width * height);

            if (arr[l] < arr[r]) l++;
            else r--;
        }
        return maxArea;
    }
}