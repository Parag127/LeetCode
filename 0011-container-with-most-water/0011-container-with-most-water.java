class Solution {
    public int maxArea(int[] height) {
        int n = height.length;


        int r = n - 1;
        int l = 0;

        int maxArea = 0;
        while (l < r) {
            int width = r - l;
            int h = Math.min(height[l], height[r]);

            maxArea = Math.max(maxArea, width * h);

            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
            
        }
        return maxArea;
    }
}