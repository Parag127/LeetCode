class Solution {
    public String removeKdigits(String num, int k) {
        Deque<Character> st = new ArrayDeque<>();
        int n = num.length();
        int i = 0;
        while (i < n) {
            while (!st.isEmpty() && k > 0 && st.peek() > num.charAt(i)){
                st.pop();
                k--;
            }

            st.push(num.charAt(i));
            i++;
        }
        while (!st.isEmpty() && k > 0) {
            st.pop();
            k--;
        }

        if (st.isEmpty()) return "0";

        StringBuilder ans = new StringBuilder();
        i = st.size();
        for (int x = 0; x < i; x++) {
            ans.append(st.removeLast());
        }

        i = 0;
        int count = 0;
        while (i < ans.length() && ans.charAt(i) == '0'){
            count++;
            i++;
        }
        if (i == ans.length()) return "0";

        return ans.substring(count);
    }
}