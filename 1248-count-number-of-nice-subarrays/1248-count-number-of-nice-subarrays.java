class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return (fn (nums, k) - fn (nums, k - 1));
    }

    static int fn (int[] nums, int k) {
        if (k < 0) return 0;

        int l = 0;
        int r = 0;
        int countOdd = 0;
        int count = 0;

        while (r < nums.length) {
            if (nums[r] % 2 != 0) countOdd++;

            while (countOdd > k) {
                if (nums[l] % 2 != 0) countOdd--;
                l++;
            } 
            if (countOdd <= k) {
                count += r - l + 1;
            }

            r++;
        }
        return count;
    }
}