class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLen = 0;

        int r = 0;
        int l = 0;
        int len = 0;

        HashMap<Character, Integer> map = new HashMap<>();

        while (r < s.length()) {
            if (map.containsKey(s.charAt(r))){
                l = Math.max(l, map.get(s.charAt(r)) + 1);
                map.put(s.charAt(r), r);
            }    

            len = r - l + 1;
            maxLen = Math.max(maxLen, len);
            map.put(s.charAt(r), r);
            r++;
        }
        return maxLen;
    }
}