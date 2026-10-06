class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                st.push(0);
            } else {
                int score  = 0;

                while (st.peek() != 0) {
                    score += st.pop();
                }

                st.pop();
                
                if (score == 0) score = 1;
                else score *= 2;

                st.push(score);
            }
        }
        int ans = 0;
        while (!st.isEmpty()) {
            ans += st.pop();
        }
        return ans;
    }
}