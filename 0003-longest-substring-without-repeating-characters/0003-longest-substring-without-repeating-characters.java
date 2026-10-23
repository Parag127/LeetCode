class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        HashMap<Character, Integer> map = new HashMap<>();

        int l = 0;
        int r = 0;
        int maxLen = 0;
        int maxFreq = 0;

        while (r < s.length()) {
            
            if (map.containsKey(s.charAt(r))) {
                map.put(s.charAt(r), map.get(s.charAt(r)) + 1);
            } else {
                map.put(s.charAt(r), 1);
            }

            maxFreq = map.get(s.charAt(r));
            while (maxFreq > 1) {

                map.put(s.charAt(l), map.get(s.charAt(l)) - 1);
                
                if (map.get(s.charAt(l)) == 0) {
                    map.remove(s.charAt(l));
                }

                maxFreq = map.get(s.charAt(r));
                l++;
            }

            maxLen = Math.max(maxLen, r - l + 1);
            r++;
        }

        return maxLen;
    }
}