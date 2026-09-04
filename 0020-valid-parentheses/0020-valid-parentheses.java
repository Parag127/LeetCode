class Solution {
    public boolean isValid(String s) {
        if (s.length() % 2 != 0) return false;

        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '['){
                st.push(s.charAt(i));
            } else {
                if (st.isEmpty()) return false;

                char ch = s.charAt(i);
                if (st.peek() == '[' && ch == ']' || st.peek() == '{' && ch == '}' || st.peek() == '(' && ch == ')') st.pop();
                else return false;
            }
        }
        if (st.isEmpty()) return true;
        else return false;
    }
}