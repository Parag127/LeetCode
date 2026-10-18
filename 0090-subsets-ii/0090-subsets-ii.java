class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        subset2(0, nums, new ArrayList<>(), ans);
        return ans;
    }

    public static void subset2(int idx, int[] arr, List<Integer> list, List<List<Integer>> ans) {
        ans.add(new ArrayList<>(list));

        for (int i = idx; i < arr.length; i++) {
            if (i > idx && arr[i] == arr[i - 1]) continue;

            list.add(arr[i]);
            subset2(i + 1, arr, list, ans);
            list.remove(list.size() - 1);
        }
    }
}