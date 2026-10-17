class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i : stones) {
            pq.offer(i);
        }

        while (pq.size() > 1) {
            int x = pq.poll();
            int y = pq.poll();

            int smash = (x == y) ? 0 : x - y;

            if (smash == 0) continue;

            pq.offer(smash);
        }

        if (pq.isEmpty()) return 0;
        return pq.peek();
    }
}