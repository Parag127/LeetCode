class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < stones.length; i++) {
            pq.offer(stones[i]);
        }

        while(!pq.isEmpty() && pq.size() > 1) {
            int y = pq.poll();
            int x = pq.poll();

            int smash = y - x;
            if (smash != 0) {
                pq.offer(smash);
            }
        }

        return pq.size() == 0 ? 0 : pq.peek();
    }
}