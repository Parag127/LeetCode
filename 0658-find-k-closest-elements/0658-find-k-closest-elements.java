class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> list = new ArrayList<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a, b) -> {
                if (a.key != b.key) {
                    return Integer.compare(b.key, a.key);
                }

                return Integer.compare(b.val, a.val);
            }
        );

        for (int i = 0; i < arr.length; i++) {
            int curr = Math.abs(x - arr[i]);
            pq.offer(new Pair(arr[i], curr));

            if (pq.size() > k) {
                pq.poll();
            }
        }

        for (int i = 0; i < k; i++) {
            list.add(0, pq.poll().val);
        }

        Collections.sort(list);
        return list;
    }

    class Pair{
        int key;
        int val;

        Pair(int val1, int key1) {
            this.val = val1;
            this.key = key1;
        }
    }
}