class Solution {
    public String minWindow(String s, String t) {
        int l = 0;
        int r = 0;
        int start  = 0;
        int minLen = Integer.MAX_VALUE;
        int count = 0;

        int[] hash = new int[256];
        int m = t.length();

        for (int i = 0; i < m; i++) hash[t.charAt(i) - 'A']++;

        while (r < s.length()) {
            if (hash[s.charAt(r) - 'A'] > 0) count++;

            hash[s.charAt(r) - 'A']--;

            while (count == m) {
                if (r - l + 1 < minLen) {
                    minLen = r - l + 1;
                    start = l;
                } 

                if (hash[s.charAt(l) - 'A'] >= 0) count--;

                hash[s.charAt(l) - 'A']++;
                l++;
            }
            r++;
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}