class Solution {
    public int missingNumber(int[] nums) {
        int XOR1 = 0;
        int XOR2 = 0;
        for (int i = 0; i < nums.length; i++) {
            XOR1 ^= nums[i];
            XOR2 ^= i + 1;
        }
        int ans = XOR1 ^ XOR2;
        return ans;
    }
}