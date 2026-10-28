class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int n = asteroids.length;
        int i = 0;

        Deque<Integer> st = new ArrayDeque<>();

        while (i < n) {
            boolean destroyed = false;
            int aste = asteroids[i];

            while (!st.isEmpty() && st.peek() > 0 && aste < 0) {

                if (st.peek() == Math.abs(aste)) {
                    destroyed = true;
                    st.pop();
                    break;
                }

                else if (st.peek() > Math.abs(aste)) {
                    destroyed = true;
                    break; 
                } else {
                    st.pop();
                }
            }

            if (!destroyed) {
                st.push(aste);
            }
            i++;
        }

        int[] ans = new int[st.size()];

        int x = st.size();

        for (int a = 0; a < x; a++) {
            ans[a] = st.removeLast();
        }

        return ans;
    }
}