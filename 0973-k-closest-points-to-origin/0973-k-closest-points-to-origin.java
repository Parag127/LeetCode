class Solution {
    public int[][] kClosest(int[][] points, int k) {
        
        PriorityQueue<Pair<Integer, Pair<Integer, Integer>>> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(b.getKey(), a.getKey())
        );

        for (int i = 0; i < points.length; i++) {
            int x = points[i][0];
            int y = points[i][1];
            pq.offer(new Pair(x * x + y * y, new Pair(x, y)));

            if (pq.size() > k) pq.poll();
        }
        int[][] ans = new int[k][2];

        int i = 0;
        while (!pq.isEmpty() && i < k) {
            Pair<Integer, Integer> p = pq.poll().getValue();

            int x = p.getKey();
            int y = p.getValue();
            ans[i][0] = x;
            ans[i][1] = y;
            i++;
        }

        return ans;

    }
    class Pair <K, V> {
        K key;
        V val;

        Pair(K key, V val) {
            this.key = key;
            this.val = val;
        }

        K getKey() {
            return key;
        }

        V getValue() {
            return val;
        }
    }
}