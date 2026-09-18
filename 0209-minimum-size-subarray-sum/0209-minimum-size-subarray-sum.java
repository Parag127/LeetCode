class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int l = 0; 
        int r = 0;
        int minLen = Integer.MAX_VALUE;
        int sum = 0;
        while (r < nums.length) {
            sum += nums[r];

            while (sum >= target && l <= r) {
                sum -= nums[l];
                minLen = Math.min(minLen, r - l + 1);
                l++;
            }

            r++;
        }

        if (minLen == Integer.MAX_VALUE) return 0;
        return minLen;
    }
}