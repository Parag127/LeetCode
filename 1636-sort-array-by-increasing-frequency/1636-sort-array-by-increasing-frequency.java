class Solution {
    public int[] frequencySort(int[] nums) {
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
                if (a.freq != b.freq) {
                    return Integer.compare(a.freq, b.freq);
                }
                return Integer.compare(b.val, a.val);
            }
        );

        for (Map.Entry<Integer, Integer> mpp : map.entrySet()) {
            pq.offer(new Pair(mpp.getKey(), mpp.getValue()));
        }
        
        int[] arr = new int[nums.length];
        int i = 0;
        while (!pq.isEmpty()) {
            for (int k = 0; k < pq.peek().freq; k++) {
                arr[i] = pq.peek().val;
                i++;
            }
            pq.poll();
        }
        return arr;
    }
    
    class Pair {
        int freq;
        int val;

        Pair(int val, int freq) {
            this.freq = freq;
            this.val = val;
        }
    }
}