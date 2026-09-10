class Solution {
    public String removeKdigits(String num, int k) {
        if (k == num.length()) return "0";

        Deque<Character> st = new ArrayDeque<>();
        int i = 0;

        while (i < num.length()) {
            while (!st.isEmpty() && k > 0 && st.peek() > num.charAt(i)) {
                st.pop();
                k--;
            }
            st.push(num.charAt(i));
            i++;
        }

        while (k > 0 && !st.isEmpty()) {
            st.pop();
            k--;
        }

        if (st.isEmpty()) return "0";

        StringBuilder ans = new StringBuilder();

        while (!st.isEmpty()) {
            ans.append(st.removeLast());
        }

        i = 0;

        while (i < ans.length() && ans.charAt(i) == '0') {
            i++;
        }

        if (i == ans.length()) {
            return "0";
        }

        return ans.substring(i);
        
    }
}