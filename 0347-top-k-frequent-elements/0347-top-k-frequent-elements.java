class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        } 

        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a, b) -> {
                if (a.key != b.key) {
                    return Integer.compare(a.key, b.key);
                }   
                return Integer.compare(a.val, b.val);
            }
        );

        for (Map.Entry<Integer, Integer> mpp : map.entrySet()) {
            pq.offer(new Pair(mpp.getValue(), mpp.getKey()));

            if (pq.size() > k) pq.poll();
        }

        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = pq.poll().val;
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