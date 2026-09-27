class Solution {
    public int[] topKFrequent(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1);
            } else {
                map.put(arr[i], 1);
            }
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a.key, b.key)
        );

        for (Map.Entry <Integer, Integer> entry : map.entrySet()) {
            pq.offer(new Pair (entry.getKey(), entry.getValue()));

            if (pq.size() > k) {
                pq.poll();
            }
        }     

        int[] ans = new int[k];
        int i = 0;
        while (!pq.isEmpty()) {
            ans[i] = pq.poll().val;
            i++;
        }
           
        return ans;
    }

    class Pair{
        int key;
        int val;

        Pair (int val, int key) {
            this.val = val;
            this.key = key;
        }
    }
}