class KthLargest {
    PriorityQueue<Integer> pq;
    int x;
    public KthLargest(int k, int[] nums) {
        this.x = k;
        pq = new PriorityQueue<>();

        for (int i = 0; i < nums.length; i++) {
            pq.offer(nums[i]);
            
            if (pq.size() > k) pq.poll();
        }
    }
    
    public int add(int val) {
        pq.offer(val);

        if (pq.size() > x) pq.poll();
        return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */