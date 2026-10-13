class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < words.length; i++) {
            if (map.containsKey(words[i])) {
                map.put(words[i], map.get(words[i]) + 1);
            } else {
                map.put(words[i], 1);
            }
        }

        PriorityQueue<Pair<Integer, String>> pq = new PriorityQueue<>(
            (a, b) -> {
                int cmp = Integer.compare(a.key, b.key);

                if (cmp != 0) return cmp;
                
                return b.val.compareTo(a.val);
            }
        );

        for (Map.Entry<String, Integer> mpp : map.entrySet()) {
            pq.offer(new Pair<>(mpp.getValue(), mpp.getKey()));
            if (pq.size() > k) pq.poll();
        }

        List<String> list = new ArrayList<>();

        while (!pq.isEmpty()) {
            Pair<Integer, String> p = pq.poll();

            list.add(p.getVal());
        }
        Collections.reverse(list);
        return list;
    }

    class Pair<K, V> {
        K key;
        V val;

        Pair (K key, V val) {
            this.key = key;
            this.val = val;
        }

        K getKey() { return key; }
        V getVal() { return val; }
    }
}