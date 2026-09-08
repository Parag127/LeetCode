class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        
        int n = asteroids.length;
        Deque<Integer> st= new ArrayDeque<>();
        int i = 0;
        while (i < n) {

            int aste = asteroids[i];
            boolean destroy = false;

            while (!st.isEmpty() && aste < 0 && st.peek() > 0) {
                if (st.peek() < Math.abs(aste)) {
                    st.pop();
                } else if (st.peek() == Math.abs(aste)){ 
                    st.pop();
                    destroy = true;
                    break;
                } else {
                    destroy = true;
                    break;
                }
            }

            if (!destroy) {
                st.push(aste);
            }
            i++;
        }
        int[] destroyedAste = new int[st.size()];

        for (int x = destroyedAste.length - 1; x >= 0; x--) {
            destroyedAste[x] = st.peek();
            st.pop();
        }
        return destroyedAste;
    }
}