class Solution {
    public int evalRPN(String[] tokens) {
        int n = tokens.length;
        Deque<Integer> st = new ArrayDeque<>();

        for (int i = 0; i < tokens.length; i++) {
            String token = tokens[i];

            if (token.equals("-") || token.equals("+") || token.equals("*")
                || token.equals("/")) {
                int t2 = st.peek();
                st.pop();
                int t1 = st.peek();
                st.pop();

                switch (token) {
                    case "+":
                        st.push(t1 + t2);
                        break;

                    case "-":
                        st.push(t1 - t2);
                        break;

                    case "*":
                        st.push(t1 * t2);
                        break;

                    case "/":
                        st.push(t1 / t2);
                        break;
                }
            } else {
                st.push(Integer.parseInt(token));
            }
        }
        return st.peek();
    }
}
