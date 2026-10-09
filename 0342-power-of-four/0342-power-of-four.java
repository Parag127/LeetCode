class Solution {
    public boolean isPowerOfFour(int n) {
        if (n <= 0) {
            return false;
        }

        
        int count = 0;

        while ((n & 1) != 1) {
            count++;
            n = n >> 1;
        }

        if (n == 1 && count % 2 == 0) return true;
        return false;
    }
}