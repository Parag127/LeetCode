class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new ArrayDeque<>();


        int[] ans = new int[nums.length - k + 1];
        int x = 0;

        for (int i = 0; i < nums.length; i++) {

            if (!dq.isEmpty() && dq.peekFirst() <= i - k) {
                dq.pollFirst();
            }

            while (!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]) {
                dq.pollLast();
            }

            dq.addLast(i);

            if (i + 1 >= k) {
                ans[x] = nums[dq.peekFirst()];
                x++;
            }
        }
        return ans;
    }
}