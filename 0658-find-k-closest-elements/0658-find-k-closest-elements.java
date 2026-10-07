class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a, b) -> {
                if (a.key != b.key) {
                    return Integer.compare(b.key, a.key);
                }

                return Integer.compare(b.val, a.val);
            }
        );

        for (int i = 0; i < arr.length; i++) {
            pq.offer(new Pair(Math.abs(x - arr[i]), arr[i]));

            if (pq.size() > k) pq.poll();
        }

        ArrayList<Integer> list = new ArrayList<>();
        while(!pq.isEmpty()) {
            list.add(pq.poll().val);
        }
        

        Collections.sort(list);
        return list;
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