class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                map.put (s.charAt(i), map.get(s.charAt(i)) + 1);
            } else {
                map.put(s.charAt(i), 1);
            }
        }

        PriorityQueue<Pair<Integer, Character>> pq = new PriorityQueue<> (
            (a, b) -> {
                if (b.freq != a.freq) {
                   return Integer.compare(b.freq, a.freq);
                }

                return Character.compare(a.val, b.val);
            }
        );

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            pq.offer(new Pair<>(entry.getValue(), entry.getKey()));
        }

        StringBuilder str = new StringBuilder();
        while (!pq.isEmpty()) {
            Pair <Integer, Character> p = pq.poll();
            int k = 0;
            while (p.getKey() - k != 0) {
                str.append(p.getValue());
                k++;
            }
        }

        return str.toString();
    }

    class Pair <K, V> {
        K freq;
        V val;

        Pair (K freq, V val) {
            this.freq = freq;
            this.val = val;
        }

        K getKey() { return freq; }

        V getValue() { return val; }
    }
}