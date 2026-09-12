class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> dq = new ArrayDeque<>();
        int[] ans = new int[n - k + 1];
        int i = 0;
        int j = 0;
        while (i < n) {
            if (!dq.isEmpty() && dq.peekFirst() <= i - k) {
                dq.removeFirst();
            }

            while(!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]) {
                dq.removeLast();
            }

            dq.addLast(i);
            if (i >= k - 1) {
                ans[j] = nums[dq.peekFirst()];
                j++;
            }
            i++;
        }
        return ans;
    }
}