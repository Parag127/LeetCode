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
            (a, b) -> Integer.compare(a.val, b.val)
        );

        for (Map.Entry <Integer, Integer> entry : map.entrySet()) {
            pq.offer(new Pair (entry.getValue(), entry.getKey()));

            if (pq.size() > k) {
                pq.poll();
            }
        }     

        int[] ans = new int[k];
        int i = 0;
        while (!pq.isEmpty()) {
            ans[i] = pq.poll().key;
            i++;
        }
           
        return ans;
    }

    class Pair{
        int key;
        int val;

        Pair (int val1, int key1) {
            this.key = key1;
            this.val = val1;
        }
    }
}