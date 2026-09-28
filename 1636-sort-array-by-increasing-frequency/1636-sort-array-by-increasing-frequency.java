class Solution {
    public int[] frequencySort(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1);
            } else {
                map.put(arr[i], 1);
            }
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>(
                (a, b) -> {
                    if (a.key != b.key) {
                        return Integer.compare(a.key, b.key);
                    }

                    return Integer.compare(b.val, a.val);

                });

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pq.offer(new Pair(entry.getValue(), entry.getKey()));
        }

        int[] ans = new int[arr.length];
        int i = 0;
        while (!pq.isEmpty()) {

            ans[i] = pq.peek().val;
            pq.peek().key--;
            if (pq.peek().key <= 0) {
                pq.poll();
            }
            i++;
        }

        return ans;
    }

    class Pair {
        int key;
        int val;

        Pair(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
}