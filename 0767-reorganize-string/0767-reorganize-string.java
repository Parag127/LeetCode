class Solution {
    public String reorganizeString(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            } else {
                map.put(s.charAt(i), 1);
            }
        }

        PriorityQueue<Pair<Integer, Character>> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(b.getKey(), a.getKey())
        );

        for (Map.Entry<Character, Integer> mpp : map.entrySet()){
            pq.offer(new Pair<>(mpp.getValue(), mpp.getKey()));
        }

        Queue< Pair<int[], Character>> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        int time = 0;

        while (!pq.isEmpty() || !q.isEmpty()) {
            time++;

            while (!q.isEmpty() && q.peek().getKey()[1] == time) {
                pq.offer(new Pair(q.peek().getKey()[0], q.peek().getValue()));
                q.poll();
            }

            if (!q.isEmpty() && pq.isEmpty()) {
                return "";
            }

            if (!pq.isEmpty()) {
                Pair<Integer, Character> p = pq.poll();
                int freq = p.getKey();
                char ch = p.getValue();
                sb.append(ch);

                freq--;

                if (freq > 0) {
                    q.offer(new Pair<>(new int[] {freq, time + 2}, ch));
                }
            }
        }
        return sb.toString();
    }

    class Pair<K, V> {
        K val;
        V ch;

        Pair (K val, V ch) {
            this.val = val;
            this.ch = ch;
        }

        K getKey() { return val; }
        V getValue() { return ch; }
    }
}