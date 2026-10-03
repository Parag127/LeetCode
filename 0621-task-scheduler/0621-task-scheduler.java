class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < tasks.length; i++) {
            if (map.containsKey(tasks[i])) {
                map.put(tasks[i], map.get(tasks[i]) + 1);
            } else {
                map.put(tasks[i], 1);
            }
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i : map.values()) {
            pq.offer(i);
        }

        Queue< int[] > q = new LinkedList<>();
        int time = 0;

        while (!pq.isEmpty() || !q.isEmpty()) {
            
            time++;

            if (!q.isEmpty() && q.peek()[1] == time) {
                pq.offer(q.poll()[0]);
            }

            if (!pq.isEmpty()) {
                int freq = pq.poll();

                freq--;
                if (freq > 0) {
                    q.offer(new int[] {freq, time + n + 1});
                }
            }
        }
        return time;
    }
}