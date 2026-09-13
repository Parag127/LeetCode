class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int l = 0;
        int r = n - 1;
        int maxArea = 0;
        int i = 0;
        while (l < r) {
            int width = r - l;
            int ht = Math.min(height[l], height[r]);

            maxArea = Math.max(maxArea, width * ht);

            if (height[l] >= height[r]) r--;
            else l++;
        }
        return maxArea;
    }
}