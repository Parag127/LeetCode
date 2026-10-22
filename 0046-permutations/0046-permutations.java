class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        recurPermute(0, nums, ans);
        return ans;
    }

    static void recurPermute(int idx, int[] nums, List<List<Integer>> ans) {
        if (idx == nums.length) {
            List<Integer> list = new ArrayList<>();

            for (int i : nums) {
                list.add(i);
            }

            ans.add(new ArrayList<>(list));
        }

        for (int i = idx; i < nums.length; i++) {
            swap(nums, i, idx);
            recurPermute(idx + 1, nums, ans);
            swap(nums, i, idx);
        }
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}