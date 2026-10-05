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
            (a, b) -> Integer.compare(b.freq, a.freq)
        );

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            pq.offer(new Pair<>(entry.getValue(), entry.getKey()));
        }

        Queue< Pair<int[], Character> > q = new LinkedList<>();
        int time = 0;
        
        StringBuilder str = new StringBuilder();
        while (!pq.isEmpty() || !q.isEmpty()) {
            time++;

            while (!q.isEmpty() && q.peek().getKey()[1] == time) {
                Pair <int[], Character> p = q.poll();

                pq.offer(new Pair<>(p.getKey()[0], p.getValue()));
            }

            if (pq.isEmpty() && !q.isEmpty()) return "";
            
            if (!pq.isEmpty()) {
                Pair<Integer, Character> p = pq.poll();

                str.append(p.getValue());
                int freq = p.getKey();
                freq--;

                if (freq > 0) {
                    q.offer(new Pair<>(new int[] {freq, time + 2}, p.getValue()));
                }
            }
        }
        return str.toString();
    }

    class Pair <F, C> {
        F freq;
        C ch;

        Pair (F freq, C ch) {
            this.freq = freq;
            this.ch = ch;
        }

        F getKey() { return freq; }
        C getValue() { return ch; }
    }
}