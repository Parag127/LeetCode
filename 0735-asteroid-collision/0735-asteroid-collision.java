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
                    st.pop();
                    destroyed = true;
                    break;

                } else if (st.peek() > Math.abs(aste)) {
                    destroyed = true;
                    break;
                } else {
                    st.pop();
                }
            }
            if (!destroyed) {
                st.push(asteroids[i]);
            }
            i++;
        }
        int x = st.size();
        int[] ans = new int[x];
        for (int k = 0; k < x; k++) {
            ans[k] = st.removeLast();
        }

        return ans;
    }
}