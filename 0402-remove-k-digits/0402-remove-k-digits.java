class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> st = new Stack<>();
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