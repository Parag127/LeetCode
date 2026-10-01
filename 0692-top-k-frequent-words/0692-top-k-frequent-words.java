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

        PriorityQueue<Pair> pq =  new PriorityQueue<>(
            (a, b) ->  {
                if (a.key != b.key) {
                    return Integer.compare(a.key, b.key);
                }

                return b.word.compareTo(a.word);
            }
        );

        for (Map.Entry <String, Integer> entry : map.entrySet()) {
            pq.offer(new Pair(entry.getValue(), entry.getKey()));

            if (pq.size() > k) {
                pq.poll();
            }
        }

        String[] arr = new String[k];
        for (int i = k - 1; i >= 0; i--) {
            arr[i] = pq.poll().word;
        }
        return Arrays.asList(arr);    
    }

    class Pair {
        int key;
        String word;

        Pair(int key, String word) {
            this.key = key;
            this.word = word;
        }
    }
}