class Solution {
    public int longestSubarray(int[] nums) {
        int maxLen = 0;
        int l = 0;
        int r = 0;
        int zero = 0;
        while (r < nums.length) {
            if (nums[r] == 0) zero++;

            if (zero > 1) {
                if (nums[l] == 0) zero--;
                l++;    
            }
            maxLen = Math.max(maxLen, r - l + 1);
            r++;
        }

        if (maxLen == 0) return 0;

        return (maxLen - 1); 
    }
}