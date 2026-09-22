class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int m = s1.length();
        int[] hash = new int[26];

        for (int i = 0; i < m; i++) hash[s1.charAt(i) - 'a']++;

        int l = 0;
        int r = 0;
        int count = 0;

        while (r < s2.length()) {
            if (hash[s2.charAt(r) - 'a'] > 0) count++;

            hash[s2.charAt(r) - 'a']--;

            if (r - l + 1 > m) {
                if (hash[s2.charAt(l) - 'a'] >= 0) count--;

                hash[s2.charAt(l) - 'a']++;
                l++;
            }
            if (count == m) return true;
            r++;
         }
         return false;
    }
}