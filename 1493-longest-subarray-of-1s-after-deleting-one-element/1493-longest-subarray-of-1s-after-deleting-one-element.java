class Solution {
    public int longestSubarray(int[] nums) {
        int l = 0;
        int r = 0;
        int maxLen = 0;
        int zeroes = 0;
        while (r < nums.length) {
            if (nums[r] == 0) zeroes++;

            if (zeroes > 1) {
                if (nums[l] == 0) zeroes--;
                l++;
            }

            if (zeroes <= 1) {
                maxLen = Math.max(maxLen, r - l + 1);
            }
            r++;
        }

        if (maxLen == 0) return 0;
        return (maxLen - 1);
    }
}