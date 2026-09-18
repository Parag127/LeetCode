class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int count = 0;

        int l = 0;
        int r = 0;
        int product = 1;
        while (r < nums.length) {
            product *= nums[r];
            while (product >= k && l <= r) {
                product /= nums[l];
                l++;
            }
            count += r - l + 1;
            r++;
        }
        return count;
    }
}