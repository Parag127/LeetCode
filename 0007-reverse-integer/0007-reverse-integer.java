class Solution {
    public int reverse(int x) {
        if (x > Integer.MAX_VALUE || x < Integer.MIN_VALUE) return 0;
        return fn (x, 0);
    }
    public int fn (int n,int rev) {
        if (n == 0) return rev;
        int d = n % 10;

        if (rev > Integer.MAX_VALUE / 10 || rev < Integer.MIN_VALUE/ 10) return 0;
        return fn(n / 10, rev * 10 + d);
    }
}