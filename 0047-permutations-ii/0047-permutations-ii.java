class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        boolean[] freq = new boolean[nums.length];
        Arrays.sort(nums);
        recurPermute(nums, freq, list, ans);
        return ans;
    }

    static void recurPermute(int[] nums, boolean[] freq, List<Integer> ds, List<List<Integer>> ans) {
        if (ds.size() == nums.length) {
            ans.add(new ArrayList<>(ds));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && freq[i - 1] == false && nums[i] == nums[i - 1]) continue;
            if (!freq[i]) {
                freq[i] = true;
                ds.add(nums[i]);
                recurPermute(nums, freq, ds, ans);
                ds.remove(ds.size() - 1);
                freq[i] = false;
            }
        }
    }


}