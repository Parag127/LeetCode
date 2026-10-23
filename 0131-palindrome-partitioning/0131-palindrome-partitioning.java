class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> list = new ArrayList<>();

        partition(0, s, list, ans);
        return ans;
    }

    static void partition(int idx, String s, List<String> list, List<List<String>> ans) {
        if (idx == s.length()) {
            ans.add(new ArrayList<>(list));
            return;
        }

        for (int i = idx; i < s.length(); i++) {
            
            if (isPalindrome(s, idx, i)) {
                list.add(s.substring(idx, i + 1));
                partition(i + 1, s, list, ans);
                list.remove(list.size() - 1);
            }
        }
    }

    static boolean isPalindrome(String s, int start, int end) {

        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}