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

        String ans = "";
        while (!st.isEmpty()) {
            ans += st.peek();
            st.pop();
        }

        StringBuilder rev = new StringBuilder(ans).reverse();

        int j = 0;

        while (j < rev.length() && rev.charAt(j) == '0') {
            j++;
        }

        rev = new StringBuilder(rev.substring(j));

        if (rev.length() == 0) {
            return "0";
        }

        return rev.toString();
        
    }
}