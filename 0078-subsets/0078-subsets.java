class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        return subseQuences(0, nums, list, ans);
    }

    public List<List<Integer>> subseQuences(int i, int[] nums, List<Integer> list, List<
    List<Integer>> ans) {
        if (i == nums.length) {
            ans.add(new ArrayList<>(list));
            return ans;
        }

        list.add(nums[i]);

        subseQuences(i + 1, nums, list, ans);

        list.remove(list.size() - 1);

        subseQuences(i + 1, nums, list, ans);
        return ans;
    }
}