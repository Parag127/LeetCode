class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        int i = 0;

        while (i < s.length()) {
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                st.push(s.charAt(i));
            } else {

                if (st.isEmpty()) return false;

                char ch = st.pop();

                if (!((ch == '{' && s.charAt(i) == '}') || (ch == '(' && s.charAt(i) == ')') || (ch == '[' && s.charAt(i) == ']'))) {
                    return false;
                } 
            }
            i++;
        }

        return st.isEmpty();
    }
}